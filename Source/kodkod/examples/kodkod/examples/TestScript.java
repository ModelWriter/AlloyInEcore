package kodkod.examples;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestScript {

    private final static int testCount = 1;

    private final static int timeLimit = 60;
    private final static TimeUnit timeUnit = TimeUnit.SECONDS;

    public static void main(String[] args) throws Exception {
        List<Class> classes = getClasses(TestScript.class.getClassLoader(), "kodkod/examples/models");

        System.out.println("Classes:");

        for (Class c : classes) {
            System.out.println("Class: " + c);
        }

        System.out.println();

        long timeLimitMs = timeUnit.toMillis(timeLimit);

        try (PrintWriter out = new PrintWriter("test_script.out")) {
            out.println(new Date().toString());
            out.println();
            out.flush();
            classes.forEach(testClass -> {
                System.out.println(testClass.getName() + " is being tested.");
                out.println(testClass.getName() + " is being tested.");
                out.flush();

                String cp = Objects.requireNonNull(testClass.getClassLoader().getResource("")).getFile();
                cp = cp + ":" + System.getenv("PWD") + ":" + System.getProperty("java.class.path");

                String classStr = testClass.getName();

                String command = "java -cp " + cp + " " + classStr;

                for (int i = 0; i < testCount; i++) {

                    final int testNo = i + 1;

                    System.out.println("Test " + testNo + " is started.");

                    long time = System.currentTimeMillis();

                    try {
                        Process process = Runtime.getRuntime().exec(command);

                        long procTime = System.currentTimeMillis();

                        boolean flag = true;

                        while (process.isAlive()) {
                            if (System.currentTimeMillis() - procTime > timeLimitMs) {
                                process.destroy();
                                flag = false;
                            }
                        }

                        if (flag && process.exitValue() == 0) {
                            time = System.currentTimeMillis() - time;

                            System.out.println("Time: " + time + " ms");
                            out.println("Test " + testNo + ": " + time + " ms");
                            out.flush();
                        } else if (flag && process.exitValue() != 0) {
                            System.out.println("### Error ###");

                            BufferedReader in = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                            String line;

                            boolean done = false;

                            if ((line = in.readLine()) != null) {
                                System.out.println(line);
                                if (line.startsWith("Exception in thread")) {
                                    line = line.replaceFirst("Exception in thread \".+\" ", "");
                                    line = line.substring(0, line.indexOf(':'));

                                    out.println("Test " + testNo + ": " + line);
                                    out.flush();

                                    done = true;
                                }
                            }

                            while ((line = in.readLine()) != null) {
                                System.out.println(line);
                            }
                            in.close();

                            if (!done) {
                                out.println("Test " + testNo + ": Error");
                                out.flush();
                            }
                        } else {
                            System.out.println("Couldn't solve in " + timeLimit + " " + timeUnit.toString().toLowerCase());
                            out.println("Test " + testNo + ": Couldn't solve in " + timeLimit + " " + timeUnit.toString().toLowerCase());
                            out.flush();
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                        /*try {
                            testClass.getMethod("main", String[].class).invoke(null, new Object[]{new String[0]});
                        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                            e.printStackTrace();
                        }*/

                }

                out.println();
                out.flush();
            });

            System.out.println("Finished.");
            out.println("Finished.");
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.exit(0);
    }

    private static List<Class> getClasses(ClassLoader cl, String pack) throws Exception {

        String dottedPackage = pack.replaceAll("[/]", ".");
        List<Class> classes = new ArrayList<>();
        URL upackage = cl.getResource(pack);

        assert upackage != null;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader((InputStream) upackage.getContent()));
        //DataInputStream dis = new DataInputStream((InputStream) upackage.getContent());
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (line.endsWith(".class")) {
                classes.add(Class.forName(dottedPackage + "." + line.substring(0, line.lastIndexOf('.'))));
            } else {
                classes.addAll(getClasses(cl, pack + "/" + line));
            }
        }
        return classes;
    }

}
