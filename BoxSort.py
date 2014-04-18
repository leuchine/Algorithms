#BoxSort

def BoxSort(array,k):
    count=[]
    for i in range(0,k+1):
        count.append(0)
    for i in range(0,len(array)):
        count[array[i]]=count[array[i]]+1
    for i in range(2,k+1):
        count[i]=count[i]+count[i-1]
    result=[]
    for i in range(0,len(array)):
        result.append(0)
    x=range(0,len(array))
    x.reverse()
    for i in x:
        result[count[array[i]]-1]=array[i]
        count[array[i]]=count[array[i]]-1
    return result

array=[1,3,2,4,5,8,7,9,10,6]
print(BoxSort(array,100))
        
