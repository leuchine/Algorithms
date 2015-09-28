v=4
graph=[[] for i in range(v)]

graph[0].append(1)
graph[0].append(2)
graph[1].append(2)
graph[1].append(3)
graph[2].append(3)
color=[]
parent=[]
d=[]
for i in range(v):
    color.append(0)
    parent.append(0)
    d.append(0)
color[0]=1
queue=[]
queue.insert(0,0)
while queue!=[]:
    current=queue.pop()
    for i in graph[current]:
        if color[i]==0:
            color[i]=1
            parent[i]=current
            d[i]=d[current]+1
            queue.insert(0,i)
    color[current]=2
print(color)
print(d)
print(parent)
