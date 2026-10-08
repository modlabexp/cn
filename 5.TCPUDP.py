import socket
import threading

HOST = "127.0.0.1"
TCP_PORT = 5000
UDP_PORT = 5001

# TCP Server
def tcp_server():
    s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    s.bind((HOST, TCP_PORT))
    s.listen(1)

    print("TCP Server waiting...")
    conn, addr = s.accept()
    print("TCP Client connected")

    while True:
        msg = conn.recv(1024).decode()
        if not msg:
            break
        print("TCP Client:", msg)

        reply = input("TCP Server: ")
        conn.send(reply.encode())

    conn.close()


# UDP Server
def udp_server():
    s = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
    s.bind((HOST, UDP_PORT))

    print("UDP Server waiting...")

    while True:
        msg, addr = s.recvfrom(1024)
        print("UDP Client:", msg.decode())

        reply = input("UDP Server: ")
        s.sendto(reply.encode(), addr)


threading.Thread(target=tcp_server, daemon=True).start()
threading.Thread(target=udp_server, daemon=True).start()

input("Server running. Press Enter to stop...")
