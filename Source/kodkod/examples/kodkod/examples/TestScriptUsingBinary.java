package kodkod.examples;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class TestScriptUsingBinary {

    private final static int testCount = 1;

    private final static int timeLimitForConversion = 1;
    private final static int timeLimitForSolving = 5;

    private final static TimeUnit timeUnit = TimeUnit.MINUTES;

    public static void main(String[] args) throws Exception {
        List<Class> classes = getClasses(TestScriptUsingBinary.class.getClassLoader(), "kodkod/examples/models");

        System.out.println("Classes:");

        for (Class c : classes) {
            System.out.println("Class: " + c);
        }

        System.out.println();

        long timeLimitForConversionMs = timeUnit.toMillis(timeLimitForConversion);
        long timeLimitForSolvingMs = timeUnit.toMillis(timeLimitForSolving);

        try (PrintWriter out = new PrintWriter("test_script_binary.out")) {
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

                long time = System.currentTimeMillis();

                try {
                    Process process = Runtime.getRuntime().exec(command);

                    long procTime = System.currentTimeMillis();

                    boolean flag = true;

                    while (process.isAlive()) {
                        if (System.currentTimeMillis() - procTime > timeLimitForConversionMs) {
                            process.destroy();
                            flag = false;
                        }
                    }

                    if (flag && process.exitValue() == 0) {
                        time = System.currentTimeMillis() - time;

                        System.out.println("Conversion time: " + time + " ms");
                        out.println("SMT-LIB file created in " + time + " ms");
                        out.flush();

                        String smtFileName = new File("SMT" + System.getProperty("file.separator") + testClass.getSimpleName().toLowerCase() + ".smt").getAbsolutePath();

                        command = "z3 " + smtFileName;

                        for (int i = 0; i < testCount; i++) {

                            final int testNo = i + 1;

                            System.out.println("Test " + testNo + " is started.");

                            time = System.currentTimeMillis();

                            try {
                                process = Runtime.getRuntime().exec(command);

                                procTime = System.currentTimeMillis();

                                flag = true;

                                while (process.isAlive()) {
                                    if (System.currentTimeMillis() - procTime > timeLimitForSolvingMs) {
                                        process.destroy();
                                        flag = false;
                                    }
                                }

                                if (flag) {
                                    time = System.currentTimeMillis() - time;

                                    System.out.println("Time: " + time + " ms");
                                    out.println("Test " + testNo + ": " + time + " ms");
                                    out.flush();
                                } else {
                                    System.out.println("Couldn't solve in " + timeLimitForSolving + " " + timeUnit.toString().toLowerCase());
                                    out.println("Test " + testNo + ": Couldn't solve in " + timeLimitForSolving + " " + timeUnit.toString().toLowerCase());
                                    out.flush();
                                }

                                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                                BufferedReader err = new BufferedReader(new InputStreamReader(process.getErrorStream()));

                                String line;

                                try {
                                    while ((line = in.readLine()) != null) {
                                        System.out.println(line);
                                    }
                                }
                                catch (Exception ignored) { }


                                try {
                                    while ((line = err.readLine()) != null) {
                                        System.out.println(line);
                                    }
                                }
                                catch (Exception ignored) { }

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                    } else if (flag && process.exitValue() != 0) {
                        System.out.println("### Error ###");

                        BufferedReader in = new BufferedReader(new InputStreamReader(process.getErrorStream()));
                        String line;

                        if ((line = in.readLine()) != null) {
                            System.out.println(line);
                            if (line.startsWith("Exception in thread")) {
                                line = line.replaceFirst("Exception in thread \".+\" ", "");
                                line = line.substring(0, line.indexOf(':'));

                                out.println(line);
                                out.flush();
                            } else {
                                out.println("Unknown error while creating SMT-LIB file!");
                                out.flush();
                            }
                        } else {
                            out.println("Unknown error while creating SMT-LIB file!");
                            out.flush();
                        }

                        while ((line = in.readLine()) != null) {
                            System.out.println(line);
                        }
                        in.close();
                    } else {
                        System.out.println("Couldn't create SMT-LIB file in " + timeLimitForConversion + " " + timeUnit.toString().toLowerCase());
                        out.println("Couldn't create SMT-LIB file in " + timeLimitForConversion + " " + timeUnit.toString().toLowerCase());
                        out.flush();
                    }

                } catch (IOException e) {
                    e.printStackTrace();
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
