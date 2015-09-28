graph=[[0,3,8,1000,-4],[1000,0,1000,1,7],[1000,4,0,1000,1000],[2,1000,-5,0,1000],[1000,1000,1000,6,0]]
L=[[0,3,8,1000,-4],[1000,0,1000,1,7],[1000,4,0,1000,1000],[2,1000,-5,0,1000],[1000,1000,1000,6,0]]
for k in range(len(graph)):
    matrix=[]
    for i in range(len(graph)):
        matrix.append([])
        for j in range(len(graph[0])):
            if L[i][j]>L[i][k]+L[k][j]:
                matrix[len(matrix)-1].append(L[i][k]+L[k][j])
            else:               
                matrix[len(matrix)-1].append(L[i][j])
    L=matrix
print(L)
