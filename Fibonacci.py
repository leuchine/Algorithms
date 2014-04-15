#Fibonacci
def mul(a,b):
    e1=a[0][0]*b[0][0]+a[0][1]*b[1][0]
    e2=a[0][0]*b[0][1]+a[0][1]*b[1][1]
    e3=a[1][0]*b[0][0]+a[1][1]*b[1][0]
    e4=a[1][0]*b[0][1]+a[1][1]*b[1][1]
    return [[e1,e2],[e3,e4]]

def fibonacciMatrix(n):
    if n==0:
        return [[0,0],[0,0]]
    if n==1:
        return [[1,1],[1,0]]
    if n%2==0:
        matrix=fibonacciMatrix(n/2)
        return mul(matrix,matrix)
    else:
        matrix=fibonacciMatrix((n-1)/2)
        return mul(mul(matrix,matrix),[[1,1],[1,0]])

def fibonacci(n):
    return fibonacciMatrix(n)[0][1]

number=raw_input()
print(fibonacci(int(number)))
