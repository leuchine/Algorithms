#Find the n least element
import math,random

def divide(array,p,q):
    location=int(math.floor(p+(q-p)*random.random()))
    temp=array[location]
    array[location]=array[p]
    array[p]=temp
    key=array[p]
    i=p
    for j in range(p,q+1):
        if array[j]<key:
            i=i+1
            temp=array[j]
            array[j]=array[i]
            array[i]=temp
    array[p]=array[i]
    array[i]=key
    return i
    
def find(array,p,q,n):
    if(p==q):
        return p
    else:
        mid=divide(array,p,q)
        order=mid-p+1
        if order==n:
            return mid
        elif order>=n:
            return find(array,p,mid-1,n)      
        else:
            return find(array,mid+1,q,n-order)

array=[4,1,3,2,5]
position=find(array,0,4,3)
print(array[position])
