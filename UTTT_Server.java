package UTTT_V_4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;
import java.util.LinkedList;

@SuppressWarnings("serial")
public class UTTT_Server implements Serializable {
    static DataInputStream fromClient1 = null;
    static DataOutputStream toClient1 = null;
    static DataInputStream fromClient2 = null;
    static DataOutputStream toClient2 = null;
    static ServerSocket serverSocket;
    static Socket socket1 = null;
    static Socket socket2 = null;
    static boolean ttt = false;
    static int maxNumberOfClients = 2;
    static Object lock = new Object();
    static int lockConnect = 0;
    static LinkedList<Socket> list = new LinkedList<Socket>();

    public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException {
        startServer();
        if (lockConnect == 1) {
            for (; list.size() < maxNumberOfClients; ) {
                connectNewClient();
            }
        }
        
    }

    private static void startServer() throws IOException, InterruptedException {
        try {
            serverSocket = new ServerSocket();
            serverSocket.setReuseAddress(true);
            serverSocket.bind(new InetSocketAddress(8007));
            System.out.println("Server started at " + new Date() + " on port: " + serverSocket);
            lock();
        } catch (IOException e) {
            System.out.println("Failed to create server either something went wrong or port " + serverSocket + " is currently in use. \nclosing old serverPort and retrying");
        }
    }

    private static void lock() {
        lockConnect = 1;
    }

    private static void connectNewClient() {
        new Thread(() -> {
            try {
                Socket Socket = serverSocket.accept();
                DataInputStream fromClient = new DataInputStream(Socket.getInputStream());
                DataOutputStream toClient = new DataOutputStream(Socket.getOutputStream());
                System.out.println("Client connected at " + new Date());
                list.add(Socket);

                if (list.size() == 1) {
                    fromClient1 = fromClient;
                    toClient1 = toClient;
                } else if (list.size() == 2) {
                	fromClient2 = fromClient;
                    toClient2 = toClient;
                }
                
                if (list.size() == maxNumberOfClients) {
                    sendServerIsFull();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
        }).start();
    }
    
    private static void sendServerIsFull() throws ClassNotFoundException, IOException {
    	new Thread(() -> {
    		try {
    			toClient2.writeInt(list.size());
    			toClient2.flush();
    			toClient2.writeInt(2);
				toClient2.flush();
    			String getPlayerToken2 = fromClient2.readUTF();
		        toClient1.writeUTF(getPlayerToken2);
		        toClient1.flush();
		        System.out.println("Player: " + getPlayerToken2);
    		} catch (IOException e) {
                e.printStackTrace();
            }
    	}).start();
    	
    	new Thread(() -> {
    		try {
	    		toClient1.writeInt(list.size());
				toClient1.flush();
				toClient1.writeInt(1);
				toClient1.flush();
	    		String getPlayerToken1 = fromClient1.readUTF();
	            toClient2.writeUTF(getPlayerToken1);
	            toClient2.flush();
	            System.out.println("Player: " + getPlayerToken1);
	            try {
					gameStats();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
    		} catch (IOException e) {
                e.printStackTrace();
            }
    	}).start();
    }
	
	private static void gameStats() throws IOException, ClassNotFoundException {
		new Thread(() -> {
			try {
				while (true) {
					int cell = fromClient1.readInt();
					System.out.println("cell = " + cell);
			        toClient2.writeInt(cell);
			        toClient2.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
		
		new Thread(() -> {
			try {
				while(true) {
					int cell = fromClient2.readInt();
					System.out.println("cell = " + cell);
					toClient1.writeInt(cell);
					toClient1.flush();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}).start();
	}
	
//	private static void closeServer() {
//		new Thread(() -> {
//			try {
//				System.out.println("Closing socket");
//				if(serverSocket != null) {
//					serverSocket.close();
//				}
//				if(serverSocket == null) {
//					serverSocket.getInetAddress();
//					serverSocket.close();
//				}
//			} catch (IOException e) {
//				System.out.println("Failed to close port or port is Null");
//			}
//		}).start();
//	}
//	
//	 public static void notifyLock() {
//		 lock.notifyAll();
//	 }
}