v=5
graph=[[] for i in range(v)]

graph[0]+=[(1,1),(2,2),(4,3)]
graph[1]+=[(0,1),(2,3),(3,4)]
graph[2]+=[(0,2),(1,3),(3,5),(4,2)]
graph[3]+=[(1,4),(2,5)]
graph[4]+=[(2,2),(0,3)]
Q=[i for i in range(v)]
key=[1000 for i in range(v)]
key[0]=0
pi=[0 for i in range(v)]

mst=[]
def finMin(Q, key):
    min=1000
    for index, value in enumerate(key):
        if value < min and index in Q:
            i=index
            min=value
    return i

while Q!=[]:
    i=finMin(Q,key)
    Q.remove(i)
    if i!=0:
        mst+=[(pi[i],i)]
    for j, weight in graph[i]:
        if j in Q and weight< key[j]:
            key[j]=weight
            pi[j]=i
print(mst)

    

