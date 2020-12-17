import wx
import wx.grid
 
class GridFrame(wx.Frame):
    def __init__(self, parent):
        wx.Frame.__init__(self, parent = None, title = u'User Log Analysis', size=(1000,600),   

                      style=wx.DEFAULT_FRAME_STYLE^wx.MAXIMIZE_BOX)
 
        # Create a wxGrid object
        grid = wx.grid.Grid(self, -1)
 
        # Then we call CreateGrid to set the dimensions of the grid
        # (100 rows and 10 columns in this example)
        grid.CreateGrid(100, 10)
 
        # We can set the sizes of individual rows and columns
        # in pixels
        grid.SetRowSize(0, 60)
        grid.SetColSize(0, 120)
 
        # And set grid cell contents as strings
        grid.SetCellValue(0, 0, 'wxGrid is good')
 
        # We can specify that some cells are read.only
        grid.SetCellValue(0, 3, 'This is read.only')
        grid.SetReadOnly(0, 3)
 
        # Colours can be specified for grid cell contents
        grid.SetCellValue(3, 3, 'green on grey')
        grid.SetCellTextColour(3, 3, wx.GREEN)
        grid.SetCellBackgroundColour(3, 3, wx.LIGHT_GREY)
 
        # We can specify the some cells will store numeric
        # values rather than strings. Here we set grid column 5
        # to hold floating point values displayed with width of 6
        # and precision of 2
        grid.SetColFormatFloat(5, 6, 2)
        grid.SetCellValue(0, 6, '3.1415')
 
        self.Show()
class Panel(wx.Panel):  

    def __init__(self,parent):  

        wx.Panel.__init__(self,parent=parent, id=-1)  

        pass    

 

class Frame(wx.Frame):   

    def __init__(self):   

        wx.Frame.__init__(self, parent = None, title = u'User Log Analysis', size=(1000,600),   

                      style=wx.DEFAULT_FRAME_STYLE^wx.MAXIMIZE_BOX)   

        self.MPL = Panel(self)

        pass    

 

class App(wx.App):

    def OnInit(self):

        # self.frame = Frame()  
        self.Gridfram = GridFrame(None)

        self.Gridfram.Show()

        self.SetTopWindow(self.Gridfram)

        return True

 

if __name__ == '__main__':   

    app = App()

    app.MainLoop()