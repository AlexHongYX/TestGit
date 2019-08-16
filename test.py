# #coding:utf-8
# # 如果是Python2，中文注释会报错，需要加上上面这句话
# num = 10
# # float相当于Java中的double（双精度浮点数），Python中没有单精度浮点数
# pi = 3.14
# # ""和''没有区别
# name = "hello"
# # 动态类型的编程语言
# name = 100
# Python中的int想有多大就有多大
# num = 1000000*100000000*100000000*10000000
# print(type(num))
# print(num)
# # 复数
# num = 10+5j
# ""和''搭配嵌套使用，可以不使用转义字符
# name = "My name is 'hello'"
# print(name)
# # 如果既有""还有''，Python中还有''' '''和""" """
# # 字符串前面加上r表示原始字符串(raw_string)：字符串内转义字符失效
# # 字符串下边可以取负数，从后往前数（-1 => len-1）

# # 取字符串子串，取字符串的[start,end)区间——切片(slice)
# print(name[1:3])

# # 字符串乘一个整数 => 重复复制
# print(name * 3)
# print("=" * 30)

# # 格式化字符串 => 字符串的操作，与print函数没有关系（不推荐使用）
# num = 10
# s = 'num = %d' % num
# print(s)

# # Python中简单的格式化字符串
# num = 10
# s = 'num = {}'.format(num)
# print(s)
# # Python中更简单的格式化字符串（推荐）——3.5+版本才能用
# num = 10
# s = f'num = {num}'
# print(s)

# # 没有字符类型，只有字符串类型(字符=>长度为1的字符串)
# name = "hehe"
# print(type(name[0]))

# # Boolean类型也是一种特殊的整数类型（True为1，False为0）——不推荐使用
# val = True
# print(val)
# print(val+1)
# print(type(val))

# # 输入输出,input返回的是str类型
# # int(s) => str->int (强制类型转换)
# s = input('请输入一段内容：')
# print("s:",int(s)+1)

# # python3的/是精确除法，除完是个小数
# # //是整除，和其他语言一样
# a = 1
# b = 2
# print(a/b)
# print(a//b)

# python中不支持++/--的操作

# # **：乘方
# a = 100
# b = 100
# print(a**b)

# # a<b<c就表示a<b&&b<c
# # 逻辑与(and)：a<b and b<c
# # 逻辑或(or)
# # 逻辑非(not)
# # 同样支持短路求值

# 字符串可以直接使用==和!=进行比较
# 还可以用>和<比较两个字符串（标准：字典序）

# 列表(list)，可通过下标访问(切片操作)，列表中的元素类型可以是不同的类型<可以嵌套列表>
a = [9,5,2,7]
a[0] = 100
print(a[-1])
print(a)

# 元组(tuple)，可通过下标访问(切片操作)，元组中的元素类型也可以是不同的类型
a = (9,5,2,7)

# 列表与元组的区别
# 列表是可变对象，元组是不可变对象(列表中的元素可以被重新赋值(被修改),而元组则不行)
# int与字符串也是不可变对象

# 字典，键值对（默认为Map），按照json的格式
# 根据key取得value
a = {
    'ip':'127.0.0.1',  # 环回ip，进行自我测试
    'port':8080
}
print(a['ip'])
print(a)

# id()查看一个变量的身份标识（近似看为地址）
b = a
print(id(a))
print(id(b))
print(id(a)==id(b))
