import pymysql

def read_data(statement):
    db = pymysql.connect("localhost","root","root123","bigdataproject")
    cursor = db.cursor()
    cursor.execute(statement)
    data = cursor.fetchall()
    cursor.close()
    db.close()
    return data

print(list(read_data("select * from provincestat")))


# db = pymysql.connect("localhost","root","root123","bigdataproject")
# cursor = db.cursor()
# cursor.execute("select * from provincestat")
# data = cursor.fetchall()
# print(data)
# cursor.close()
# db.close()