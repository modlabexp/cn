import heapq

graph = {
    'A': {'B': 2, 'C': 5},
    'B': {'A': 2, 'C': 1, 'D': 4},
    'C': {'A': 5, 'B': 1, 'D': 2},
    'D': {'B': 4, 'C': 2, 'E': 3},
    'E': {'D': 3}
}

src = input("Enter source: ").upper()
dest = input("Enter destination: ").upper()

# Distance Vector (RIP)
dist = {n: float('inf') for n in graph}
parent = {n: None for n in graph}
dist[src] = 0

for _ in graph:
    for u in graph:
        for v, cost in graph[u].items():
            if dist[u] + cost < dist[v]:
                dist[v] = dist[u] + cost
                parent[v] = u

path = []
x = dest
while x:
    path.append(x)
    x = parent[x]
path.reverse()

print("\n--- Distance Vector (RIP) ---")
print("Shortest Path:", " -> ".join(path))
print("Cost:", dist[dest])

# Link State (OSPF - Dijkstra)
dist = {n: float('inf') for n in graph}
parent = {n: None for n in graph}
dist[src] = 0
pq = [(0, src)]

while pq:
    d, u = heapq.heappop(pq)

    if d != dist[u]:
        continue

    for v, cost in graph[u].items():
        nd = d + cost
        if nd < dist[v]:
            dist[v] = nd
            parent[v] = u
            heapq.heappush(pq, (nd, v))

path = []
x = dest
while x:
    path.append(x)
    x = parent[x]
path.reverse()

print("\n--- Link State (OSPF) ---")
print("Shortest Path:", " -> ".join(path))
print("Cost:", dist[dest])
