time=0
v=6
graph=[[] for i in range(v)]
graph[0]+=[1]
graph[1]+=[2,3]
graph[2]+=[0,3]
graph[4]+=[5]
color, parent, d, f =[],[],[],[]
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

def transpose(g):
    gt=[[] for i in range(len(g))]
    for i,value in enumerate(g):
        for j in value:
            gt[j].append(i)
    return gt

def visit2(index):
    print(index)
    color[index]=1
    for i in graphtrans[index]:
        if color[i]==2:
            visit2(i)
    color[index]=0

for i in range(v):
    color.append(0)
    parent.append(0)
    d.append(0)
    f.append(0)
for index, value in enumerate(color):
        if(value==0):
            visit(index)

graphtrans=transpose(graph)
order=[(value, index) for index,value in enumerate(f)]
order.sort()
order.reverse()
for value, index in order:
        if(color[index]==2):
            print('new:')
            visit2(index)
