package eu.modelwriter.core.alloyinecore.typechecking;

import javax.tools.SimpleJavaFileObject;
import java.net.URI;
import java.util.Objects;

public class JavaSourceFromString extends SimpleJavaFileObject {
    /**
     * The source code of this "file".
     */
    final String code;
    final String rawName;

    /**
     * Constructs a new JavaSourceFromString.
     *
     * @param name the name of the compilation unit represented by this file object
     * @param code the source code for the compilation unit represented by this file object
     */
    JavaSourceFromString(String name, String code) {
        super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension),
                Kind.SOURCE);
        this.code = code;
        this.rawName = name;
    }

    public String getCode() {
        return code;
    }

    public String getRawName() {
        return rawName;
    }

    @Override
    public CharSequence getCharContent(boolean ignoreEncodingErrors) {
        return code;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(rawName + code);
    }

    @Override
    public boolean equals(Object obj) {
        return this.getClass().isInstance(obj) &&
                ((JavaSourceFromString) obj).rawName.equals(this.rawName) &&
                ((JavaSourceFromString) obj).code.equals(this.code);
    }
}
