package app.service;

import app.utils.Constants;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

public class FileReadService extends FileService {
    public FileReadService(String fileName) {
        super(fileName);
    }

    public String readFile() {
        Path path = getPath(fileName);
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        try (AsynchronousFileChannel channel =
                     AsynchronousFileChannel.open(path, StandardOpenOption.READ)) {

            Future<Integer> bytesRead = channel.read(byteBuffer, 0);

            while (!bytesRead.isDone()) {
                System.out.println(Constants.READING_PROCESSING_MSG);
            }

            byteBuffer.flip();
            String data = new String((byteBuffer.array()));
            byteBuffer.clear();
            return Constants.SUCCESSFUL_OPERATION_MSG + "\n" + data;
        } catch (IOException e) {
            return e.getMessage();
        }
    }
}
