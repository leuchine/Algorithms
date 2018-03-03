import heapq

graph = {
  0: { 1:2, 2:4, 3:1 },
  1: { 2:1, 3:3 },
  2: { 4: 7},
  3: { 2: 2 },
  4: { 0:2, 3:3 }, 
  5: {}
}

#[0, 2, 3, 1, 10, -1]

visited={}
min_queue=[(0, 0)]

while len(min_queue)>0:
	cost, node=heapq.heappop(min_queue)
	if node not in visited:
		visited[node]=cost
		for neighbor, weight in graph[node].items():
			if neighbor not in visited:
				heapq.heappush(min_queue, (cost+weight, neighbor))
print(visited)
