import socket

ch=int(input("1.TCP  2.UDP\nChoice: "))

if ch==1:
    s=socket.socket()
    s.bind(("127.0.0.1",5000))
    s.listen(1)

    print("Waiting for connection...")
    c,a=s.accept()
    print("Connected")

    msg=c.recv(1024).decode()
    print("Client:",msg)

    c.send(input("Server: ").encode())
    c.close()
    s.close()

else:
    s=socket.socket(socket.AF_INET,socket.SOCK_DGRAM)

    myport=int(input("Enter your port: "))
    peerport=int(input("Enter peer port: "))

    s.bind(("127.0.0.1",myport))

    msg=input("You: ")
    s.sendto(msg.encode(),("127.0.0.1",peerport))

    data,addr=s.recvfrom(1024)
    print("Peer:",data.decode())

    s.close()
