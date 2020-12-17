import matplotlib.pyplot as plt
import pymysql

def read_data(statement):
    db = pymysql.connect("localhost","root","root123","bigdataproject")
    cursor = db.cursor()
    cursor.execute(statement)
    data = cursor.fetchall()
    cursor.close()
    db.close()
    return list(data)

provincestat = read_data("select * from provincestat;")
pagestat = read_data("select * from pagestat;")
hourstat = read_data("select * from hourstat;")

def generate_province_ui():
    province_data = []
    province_labels = []
    for each in provincestat:
        province_data.append(int(each[1]))
        province_labels.append(each[0])
    plt.xticks(rotation=300)    
    plt.rcParams['font.sans-serif']=['SimHei']
    plt.bar(range(len(province_data)),province_data,tick_label=province_labels)
    plt.title("Statistic of Ragions")
    plt.show()

def generate_page_ui():
    page_data = []
    page_labels = []
    for each in pagestat:
        if each[0] == "-":
            pass
        else:
            page_data.append(int(each[1]))
            page_labels.append(each[0])   
    plt.xticks(rotation=300)
    plt.rcParams['font.sans-serif']=['SimHei']
    plt.bar(range(len(page_data)),page_data,tick_label=page_labels)
    plt.title("Statistic of Pages")
    plt.show()

def generate_hour_ui():
    hour_data = []
    hour_lables = []
    for each in hourstat:
        hour_data.append(int(each[1]))
        hour_lables.append(each[0])
    plt.rcParams['font.sans-serif']=['SimHei']
    plt.bar(range(len(hour_data)),hour_data,tick_label=hour_lables)
    plt.title("Statistic of Hours")
    plt.show()


generate_province_ui()
# generate_page_ui()
# generate_hour_ui()