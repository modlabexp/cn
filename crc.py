def crc(data, key):
    n = len(key)
    temp = data + '0' * (n - 1)

    for i in range(len(data)):
        if temp[i] == '1':
            temp = temp[:i] + ''.join(
                '0' if temp[i+j] == key[j] else '1'
                for j in range(n)
            ) + temp[i+n:]

    return temp[-(n-1):]


def checksum(data):
    total = sum(int(x, 2) for x in data)
    total = (total & 15) + (total >> 4)
    return format((~total) & 15, '04b')


data = input("Enter binary data: ")
key = input("Enter generator: ")

r = crc(data, key)
print("CRC Remainder :", r)
print("Transmitted Data:", data + r)

words = [data[i:i+4] for i in range(0, len(data), 4)]
print("Checksum :", checksum(words))
