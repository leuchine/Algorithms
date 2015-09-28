v=4
graph=[[] for i in range(v)]

graph[0]+=[(1,1),(2,2)]
graph[1]+=[(3,3)]
graph[2]+=[(3,4)]

Q=[i for i in range(v)]
key=[1000 for i in range(v)]
key[0]=0
pi=[0 for i in range(v)]

path=[]
def finMin(Q, key):
    min=1000
    i=1000
    for index, value in enumerate(key):
        if value < min and index in Q:
            i=index
            min=value
    return i

while Q!=[]:
    i=finMin(Q,key)
    Q.remove(i)
    if i!=0:
        path+=[(pi[i],i)]
    for j, weight in graph[i]:
        if key[j]>key[i]+weight:
            key[j]=key[i]+weight
            pi[j]=i
print(path)

    

