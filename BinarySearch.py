#binary search
def search(array,key,start,end):
    if end<start:
        return -1
    center=(start+end)/2
    if key==array[center]:
         return center
    elif array[center]>key:
        return search(array,key,start,center-1)
    else:
        return search(array,key,center+1,end)
series=raw_input()
series=series.split(',')
for i in range(0,len(series)):
    series[i]=int(series[i])
print(search(series,3,0,len(series)-1))
