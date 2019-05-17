//index.js
//获取应用实例

Page({
  data: {
    imgUrls: [
      'https://images.unsplash.com/photo-1551334787-21e6bd3ab135?w=640',
      'https://images.unsplash.com/photo-1551214012-84f95e060dee?w=640',
      'https://images.unsplash.com/photo-1551446591-142875a901a1?w=640'
    ],
    autoplay: false,
    aFlag: false,
    bFlag: false,
  },

  changeAutoplay(e) {
    this.setData({
      autoplay: !this.data.autoplay
    })
  },
  showA: function() {
    this.setData({
      aFlag: true,
      bFlag: false,
      cFlag: false,
    });
  },
  showB: function () {
    this.setData({
      aFlag: false,
      bFlag: true,
      cFlag: false,
    });
  },
  showC: function () {
    this.setData({
      aFlag: false,
      bFlag: false,
      cFlag: true,
    });
  },
  jumpBtn1:function(options){
    wx.navigateTo({
      url: '../search/search',
    });
  },
  jumpBtn2: function (options) {
    wx.navigateTo({
      url: '../apply/apply',
    });
  },
})