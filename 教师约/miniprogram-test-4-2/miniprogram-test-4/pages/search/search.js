// pages/search/search.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {

  },

  /**
   * 组件的初始数据
   */
  data: {
    index1: 0,
    index2: 0,
    index3: 0,
    index4: 0,
    index5: 0,
    index6: 0,
    array1: [1, 2, 3, 4, 5,6,7,8,9,10,11,12,13,14,15,16],
    objectArray: [
      {
        id: 0,
        name: '第一周'
      },
      {
        id: 1,
        name: '第二周'
      },
      {
        id: 2,
        name: '第三周'
      },
      {
        id: 3,
        name: '第四周'
      },
      {
        id: 4,
        name: '第五周'
      },
      {
        id: 5,
        name: '第六周'
      },
      {
        id: 6,
        name: '第七周'
      },
      {
        id: 7,
        name: '第八周'
      },
      {
        id: 8,
        name: '第九周'
      },
      {
        id: 9,
        name: '第十周'
      },
      {
        id: 10,
        name: '第十一周'
      },
      {
        id: 11,
        name: '第十二周'
      },
      {
        id: 12,
        name: '第十三周'
      },
      {
        id: 13,
        name: '第十四周'
      },
      {
        id: 14,
        name: '第十五周'
      },
      {
        id: 15,
        name: '第十六周'
      }
    ],
    array2: ['一号教学楼','三号教学楼', '四号教学楼', '五号教学楼', '人文楼','实验楼','逸夫楼'],
    objectArray: [
      {
        id:0,
        name: '一号教学楼'
      },
      {
        id: 1,
        name: '三号教学楼'
      },
      {
        id: 2,
        name: '四号教学楼'
      },
      {
        id: 3,
        name: '五号教学楼'
      },
      {
        id: 4,
        name: '人文楼'
      },
      {
        id: 5,
        name: '实验楼'
      },
      {
        id: 6,
        name: '逸夫楼'
      }
    ],
    array3: [1, 2, 3, 4,5],
    objectArray: [
      {
        id: 0,
        name: '一层'
      },
      {
        id: 1,
        name: '二层'
      },
      {
        id: 2,
        name: '三层'
      },
      {
        id: 3,
        name: '四层'
      },
      {
        id: 4,
        name: '五层'
      }
    ],
    array4: [12, 34, 56, 78,910,11],
    objectArray: [
      {
        id: 0,
        name: '12节'
      },
      {
        id: 1,
        name: '34节'
      },
      {
        id: 2,
        name: '56节'
      },
      {
        id: 3,
        name: '78节'
      },
      {
        id: 4,
        name: '910节'
      },
      {
        id: 5,
        name: '11节'
      }
    ],
    array5: [1, 2, 3, 4, 5, 6, 7],
    objectArray: [
      {
        id: 0,
        name: '星期一'
      },
      {
        id: 1,
        name: '星期二'
      },
      {
        id: 2,
        name: '星期三'
      },
      {
        id: 3,
        name: '星期四'
      },
      {
        id: 4,
        name: '星期五'
      },
      {
        id: 5,
        name: '星期六'
      },
      {
        id: 6,
        name: '星期日'
      }
    ],
    array6: ['A', 'B', 'C', 'D', 'E', 'F'],
    objectArray: [
      {
        id: 0,
        name: 'A'
      },
      {
        id: 1,
        name: 'B'
      },
      {
        id: 2,
        name: 'C'
      },
      {
        id: 3,
        name: 'D'
      },
      {
        id: 4,
        name: 'E'
      },
      {
        id: 5,
        name: 'F'
      }
    ],
    // items: [
    //   { name: '1', value: '一层'},
    //   { name: '2', value: '二层'},
    //   { name: '3', value: '三层' },
    //   { name: '4', value: '四层' },
    //   { name: '5', value: '五层' },
    // ],
    //定义一个楼层的变量 数组Array
    // levelNum: []
  },

  /**
   * 组件的方法列表
   */
  methods: {
    bindPickerChange1(e) {
      console.log('picker发送选择改变，携带值为', e.detail.value)
      this.setData({
        index1: e.detail.value
      })
    },
    bindPickerChange2(e) {
      console.log('picker发送选择改变，携带值为', e.detail.value)
      this.setData({
        index2: e.detail.value
      })
    },
    bindPickerChange3(e) {
      console.log('picker发送选择改变，携带值为', e.detail.value)
      this.setData({
        index3: e.detail.value
      })
    },
    bindPickerChange4(e) {
      console.log('picker发送选择改变，携带值为', e.detail.value)
      this.setData({
        index4: e.detail.value
      })
    },
    bindPickerChange5(e) {
      console.log('picker发送选择改变，携带值为', e.detail.value)
      this.setData({
        index5: e.detail.value
      })
    },
    bindPickerChange6(e) {
      console.log('picker发送选择改变，携带值为', e.detail.value)
      this.setData({
        index6: e.detail.value
      })
    },
    // checkboxChange(e) {
    //   console.log('checkbox发生change事件，携带value值为：', e.detail.value)
    //   this.setData({
    //     levelNum: e.detail.value
    //   })
    // },
    jumpBtn3: function (options) {
      // let levelArr = this.data.levelNum.join("");
      wx.navigateTo({
        url: `../appointment/appointment?week=${this.data.array1[this.data.index1]}&build=${this.data.array2[this.data.index2]}&buildlevel=${this.data.array3[this.data.index3]}&time=${this.data.array4[this.data.index4]}&day=${this.data.array5[this.data.index5]}&buildnumber=${this.data.array6[this.data.index6]}`,
      });
    }
    // querySeat() {
    //   console.log("----发送请求---");
    //   //发送AJAX
    //   wx.request({
    //     url: 'test.php', // 接口地址(需要提供)
    //     data: {
    //       //楼号 a b c d
    //       //楼层 1 2 3
    //       //周次 01 02 03 04
    //       x: '',
    //       y: ''
    //     },
    //     header: {
    //       'content-type': 'application/json' // 默认值
    //     },
    //     success(res) {
    //       //成功后的回调函数
    //       console.log(res.data)
    //       // {
    //       //   roomNum: "101",
    //       //   isNullRoom: true
    //       // }
    //     }
    //   })
    // }

  }
})
