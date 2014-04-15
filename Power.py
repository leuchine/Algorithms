#x^n

def power(x,n):
    if n==1:
        return x
    if n%2==0:
        half=power(x,n/2)
        return half*half
    else:
        half=power(x,(n-1)/2)
        return half*half*x

series=raw_input()
series=series.split(',')
x=int(series[0])
n=int(series[1])
print(power(x,n))
