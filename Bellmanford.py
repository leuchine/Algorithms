v=4
graph=[[] for i in range(v)]

graph[0]+=[(1,1),(2,2)]
graph[1]+=[(3,3)]
graph[2]+=[(3,4)]

key=[1000 for i in range(v)]
key[0]=0
pi=[0 for i in range(v)]

for i in range(v-1):
    for j in range(v):
        for index, weight in graph[j]:
            
            if key[index]>key[j]+weight:
                print(j,index, weight)
                key[index]=key[j]+weight
                pi[index]=j
print(pi)

