//index.js
//获取应用实例
Page({
  data: {
    firstnum: '',
    secondnum: '',
    resultnum: ''
  },

  //设置setDate用来修改data中的值
  FirstInput: function (e) {
    this.setData({
      firstnum: e.detail.value
    })
  },

  SecondInput: function (e) {
    this.setData({
      secondnum: e.detail.value
    })
  },

  changeName: function (e) {
    var that = this;
    console.log("first:" + that.data.firstnum + ",second:" + that.data.secondnum);

    //使用wx.request实现与后台的连接
    wx.request({
      url: 'http://localhost:8080/WebTest/servlet/WXServlet',
      data: {
        first: this.data.firstnum,
        second: this.data.secondnum,
      },



      header: {
        'content-type': 'application/x-www-form-urlencoded'
      },
      //将方式设置为POST
      method: 'POST',
      //用以接收访问成功时后台传回的数据
      success: function (res) {
        that.setData({
          resultnum: res.data
        })
      },
    })
  }


})