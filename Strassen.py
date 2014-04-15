#Strassen

def divide(m):
    n=len(m)
    a=[]
    b=[]
    c=[]
    d=[]
    for i in range(0,n/2):
        a.append(m[i][0:n/2])
        b.append(m[i][n/2:n])
    for i in range(n/2,n):
        c.append(m[i][0:n/2])
        d.append(m[i][n/2:n])
    return [a,b,c,d]

def add(m1,m2,flag):
    result=[]
    for i in range(0,len(m1)):
        row=[]
        for j in range(0,len(m1[0])):
            if flag==1:
                row.append(m1[i][j]+m2[i][j])
            else:
                row.append(m1[i][j]-m2[i][j])
        result.append(row)
    return result

def join(l1,l2):
    result=[]
    for i in range(0,len(l1)):
        result.append(l1[i])
    for i in range(0,len(l2)):
        result.append(l2[i])
    return result

def strassen(m1,m2):
    if(len(m1)==1):
        return [[m1[0][0]*m2[0][0]]]
    l1=divide(m1)
    l2=divide(m2)
    a1=l1[0]
    b1=add(l2[1],l2[3],2)
    a2=add(l1[0],l1[1],1)
    b2=l2[3]
    a3=add(l1[2],l1[3],1)
    b3=l2[0]
    a4=l1[3]
    b4=add(l2[2],l2[0],2)
    a5=add(l1[0],l1[3],1)
    b5=add(l2[0],l2[3],1)
    a6=add(l1[1],l1[3],2)
    b6=add(l2[2],l2[3],1)
    a7=add(l1[0],l1[2],2)
    b7=add(l2[0],l2[1],1)
    p1=strassen(a1,b1)
    p2=strassen(a2,b2)
    p3=strassen(a3,b3)
    p4=strassen(a4,b4)
    p5=strassen(a5,b5)
    p6=strassen(a6,b6)
    p7=strassen(a7,b7)
    r=add(add(add(p5,p4,1),p2,2),p6,1)
    s=add(p1,p2,1)
    t=add(p3,p4,1)
    u=add(add(add(p5,p1,1),p3,2),p7,2)
    result=[]
    for i in range(0,len(r)):
        result.append(join(r[i],s[i]))
    for i in range(0,len(t)):
        result.append(join(t[i],u[i]))
    return result

print(strassen([[2,1,1,1],[1,1,1,1],[1,1,1,1],[1,1,1,1]],[[1,1,1,1],[1,1,1,1],[1,1,1,1],[1,1,1,1]]))
