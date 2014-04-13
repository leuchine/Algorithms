#MergeSort
def mergeSort(array,start,end):
    if(start==end):
        return [array[start]]
    else:
        a=mergeSort(array,start,(end+start)/2)
        b=mergeSort(array,(end+start)/2+1,end)
        c=[]
        i=0
        j=0
        while i<len(a) and j<len(b):
            if(a[i]<=b[j]):
                c.append(a[i])
                i=i+1
            else:
                c.append(b[j])
                j=j+1
        while i<len(a):
            c.append(a[i])
            i=i+1
        while j<len(b):
            c.append(b[j])
            j=j+1
        return c
series=raw_input()
series=series.split(',')
series=mergeSort(series,0,len(series)-1)
print(series)
