time=0
v=6
graph=[[] for i in range(v)]
graph[0]+=[1,2]
graph[1]+=[2,3]
graph[2]+=[3]
graph[4]+=[5]
color, parent, d, f, list=[],[],[],[],[]
def visit(index):
    global time
    time+=1
    d[index]=time
    color[index]=1
    for i in graph[index]:
        if color[i]==0:
            parent[i]=index
            visit(i)
    time+=1
    f[index]=time
    color[index]=2
    list.insert(0,index)

for i in range(v):
    color.append(0)
    parent.append(0)
    d.append(0)
    f.append(0)
for index, value in enumerate(color):
        if(value==0):
            visit(index)
print(color)
print(parent)
print(d)
print(f)
print(list)
