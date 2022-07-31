import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
    ArrayList<Client> clients = new ArrayList<>();
    ServerSocket serverSocket;

    public ChatServer() throws IOException {
        // ������� ��������� ����� �� ����� 1234
        serverSocket = new ServerSocket(1234);
    }

    public void run() {
        while (true) {
            System.out.println("Waiting...");
            try {
                // ���� ������� �� ����
                Socket socket = serverSocket.accept();
                System.out.println("Client connected!");
                // ������� ������� �� ����� �������
                Client client = new Client(socket);
                // ��������� �����
                Thread thread = new Thread(client);
                thread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
    }
}
