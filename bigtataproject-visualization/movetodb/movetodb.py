import pymysql
def get_pagestat():
    f = open("bigdataui\\movetodb\\files\pagestat.txt","r")
    result = f.readlines()
    f.close()
    pagestatlist = []
    for each in result:
        pagestat = {}
        tmp = each.replace('\n',"")
        splited_word = tmp.split('\t')
        pagestat[splited_word[0]] = splited_word[1]
        pagestatlist.append(pagestat)
    return pagestatlist

def get_hourstat():
    f = open("bigdataui\\movetodb\\files\\hourstat.txt","r")
    result = f.readlines()
    f.close()
    hourstatlist = []
    for each in result:
        hourstat = {}
        tmp = each.replace("\n","")
        splited_word = tmp.split('\t')
        hourstat[splited_word[0]] = splited_word[1]
        hourstatlist.append(hourstat)
    return hourstatlist

def get_province():
    f = open("bigdataui\\movetodb\\files\\provincestat.txt","r",encoding="utf-8")
    result = f.readlines()
    f.close()
    provincestatlist = []
    for each in result:
        provincestat = {}
        tmp = each.replace('\n',"")
        splited_word = tmp.split('\t')
        provincestat[splited_word[0]] = splited_word[1]
        provincestatlist.append(provincestat)
    return provincestatlist

def insert_into_table(listin,tablename,columname1,columname2):
    try:
        make_string_list = []
        db = pymysql.connect("localhost","root","root123","bigdataproject")
        cursor = db.cursor()
        for each in listin:
            make_string = "(\"" + list(each.keys())[0] + "\",\"" + list(each.values())[0] + "\""+")"
            print(make_string)
            make_string_list.append(make_string)
        insert_content = ",".join(make_string_list)
        # print(insert_content)
        statamaent = "insert into " +tablename + " (" + columname1 + "," + columname2 + ")" + "values" + insert_content+";"
        print(statamaent)
        cursor.execute(statamaent)
        db.commit()
        cursor.close()
        db.close()
        print("successfully insert data into "+ tablename)
    except:
        print("fail to insert data into "+ tablename)

# pagestat = get_pagestat()
# insert_into_table(pagestat,"pagestat","topic_id","value")
# provincestat = get_province()
# insert_into_table(provincestat,"provincestat","province","value")
hourstat = get_hourstat()
print(hourstat)
insert_into_table(hourstat,"hourstat","hour","value")