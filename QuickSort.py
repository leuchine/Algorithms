#quicksort

def divide(array,start,end):
    key=array[start]
    i=start
    for j in range(start+1,end+1):
        if array[j]<=key:
            i=i+1
            temp=array[j]
            array[j]=array[i]
            array[i]=temp
    temp=array[i]
    array[i]=array[start]
    array[start]=temp
    return i

def quicksort(array,start,end):
    if start>=end:
        return
    else:
        center=divide(array,start,end)
        quicksort(array,start,center-1)
        quicksort(array,center+1,end)

array=[1,3,2,4,5,9,6,8,7]
quicksort(array,0,len(array)-1)
print(array)

