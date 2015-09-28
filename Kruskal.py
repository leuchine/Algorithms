v=5
graph=[[] for i in range(v)]

graph[0]+=[(1,1),(2,2),(4,3)]
graph[1]+=[(0,1),(2,3),(3,4)]
graph[2]+=[(0,2),(1,3),(3,5),(4,2)]
graph[3]+=[(1,4),(2,5)]
graph[4]+=[(2,2),(0,3)]

edge=[(1,(0,1)),(2,(0,2)),(2,(2,4)),(3,(0,4)),(3,(1,2)),(4,(1,3)),(5,(2,3))]
component=[i for i in range(v)]
mst=[]
for i,j in edge:
    if component[j[0]]!=component[j[1]]:
        mst+=[j]
        v=component[j[1]]
        for index,value in enumerate(component):
            if value==v:
                component[index]=component[j[0]]
print(mst)
print(component)
