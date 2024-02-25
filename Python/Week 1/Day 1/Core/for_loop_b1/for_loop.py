for i in range(0,151):
    print(i)
# # Multiples of Five

for mult in range(5,1001):
    if mult % 5==0:
        print(mult)

# Counting, the Dojo Way

for count in range(1, 101):
    if count % 10 == 0:
        print("Coding Dojo")
    elif count % 5 == 0:
        print("Coding")
    else:
        print(count)
# Whoa. That Sucker's Huge 
sum=0
for odd in range(0,500001):
    if odd % 2 != 0:
        sum= odd+sum
print(sum)

# Countdown by Fours

for down in range(2018,0,-4):
    print(down)

# Flexible Counter 

lownum=2
highnum=6
multi=3 
for flexi in range(lownum, highnum + 1):
    if flexi % multi == 0:
        print(flexi)