import java.io.*;

public class FileUtils {
    private FileUtils() {
    }

    /**
     * Reads the named file, translating {@link IOException} to a
     * {@link RuntimeException} of some sort.
     *
     * @param fileName {@code non-null;} name of the file to read
     * @return {@code non-null;} contents of the file
     */
    public static byte[] readFile(String fileName) throws IOException {
        File file = new File(fileName);
        return readFile(file);
    }

    /**
     * Reads the given file, translating {@link IOException} to a
     * {@link RuntimeException} of some sort.
     *
     * @param file {@code non-null;} the file to read
     * @return {@code non-null;} contents of the file
     * @throws IOException
     */
    public static byte[] readFile(File file) throws IOException {
        if (!file.exists()) {
            throw new RuntimeException(file + ": file not found");
        }

        if (!file.isFile()) {
            throw new RuntimeException(file + ": not a file");
        }

        if (!file.canRead()) {
            throw new RuntimeException(file + ": file not readable");
        }

        long longLength = file.length();
        int length = (int) longLength;
        if (length != longLength) {
            throw new RuntimeException(file + ": file too long");
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream(length);

        InputStream in = null;
        try {
            in = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[8192];
            int bytesRead = 0;
            while ((bytesRead = in.read(buffer)) > 0) {
                baos.write(buffer, 0, bytesRead);
            }
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    // ignored.
                }
            }
        }

        return baos.toByteArray();
    }

    public static byte[] readStream(InputStream is) throws IOException {
        return readStream(is, 32 * 1024);
    }

    public static byte[] readStream(InputStream is, int initSize) throws IOException {
        if (initSize <= 0) {
            initSize = 32 * 1024;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream(initSize);
        byte[] buffer = new byte[8192];
        int bytesRead;
        while ((bytesRead = is.read(buffer)) > 0) {
            baos.write(buffer, 0, bytesRead);
        }
        return baos.toByteArray();
    }

    /**
     * Returns true if {@code fileName} names a .zip, .jar, or .apk.
     */
    public static boolean hasArchiveSuffix(String fileName) {
        return fileName.endsWith(".zip")
                || fileName.endsWith(".jar")
                || fileName.endsWith(".apk");
    }
}
