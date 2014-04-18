#Radix Sort

def bit(number,r):
    number=number/pow(10,r-1)
    return number%10
    
def BoxSort(array,k,r):
    count=[]
    for i in range(0,k+1):
        count.append(0)
    for i in range(0,len(array)):
        count[bit(array[i],r)]=count[bit(array[i],r)]+1
    for i in range(2,k+1):
        count[i]=count[i]+count[i-1]
    result=[]
    for i in range(0,len(array)):
        result.append(0)
    x=range(0,len(array))
    x.reverse()
    for i in x:
        result[count[bit(array[i],r)]-1]=array[i]
        count[bit(array[i],r)]=count[bit(array[i],r)]-1
    return result

def radixSort(array):
    result=BoxSort(array,10,1)
    result=BoxSort(result,10,2)
    result=BoxSort(result,10,3)
    return result

array=[106,108,103,102,104,105]
print(radixSort(array))
