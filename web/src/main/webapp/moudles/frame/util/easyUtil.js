//js操作页面，滚动到具体位置
// 简单的方法 参数一是时间，参数二是距离，但是有些机型，并不能兼容这个方法
window.scrollTo(10, 200)
// 模拟滚动  参数一是距离，参数二是时间
function scrollTop(number = 0, time) {
    if (!time) {
        document.body.scrollTop = document.documentElement.scrollTop = number
        return number
     }
     const spacingTime = 20
     let spacingInex = time / spacingTime
     let nowTop = document.body.scrollTop + document.documentElement.scrollTop
     let everTop = (number - nowTop) / spacingInex
     let scrollTimer = setInterval(() => {
         if (spacingInex > 0) {
             spacingInex--
             scrollTop((nowTop += everTop))
         } else {
             clearInterval(scrollTimer)
         }
     }, spacingTime)
}
// 使用，将页面滚动到某个元素
let ele = document.getElementById('scrollId')
this.scrollTop(ele.offsetTop, 200)

//localStorage存储，并且设定过期时间
let handleLocalStorage = {
    // 存储localStorage，并且设定过期时间
    setLocalStorageItem(key, value, exp) {
        var obj = new Object(),
            expires = exp.expires || null
        obj.value = value
        obj.time = new Date().getTime()
        // expires 类型
        if (expires === null) {
            delete obj.expires
        } else if (typeof expires === 'object') {
            obj.expires = expires.getTime() - obj.time
        } else if (typeof expires === 'number') {
            if ((expires | 0) !== expires) {
                throw new Error('expires must be integer number!')
            }
            // expires 小于 365、366 则，按天算。否则按时间戳算
            let days = new Date().getFullYear() % 4 === 0 ? 366 : 365
            if (expires <= days && expires > 0) {
                obj.expires = expires * 1000 * 60 * 60 * 24
            } else if (expires > days) {
                obj.expires = expires
            } else if (expires <= 0) {
                this.removeLocalStorageItem(key)
            }
        }
        localStorage.setItem(key, JSON.stringify(obj))
    },
    // getLocalStorageItem
    getLocalStorageItem(key) {
        var obj = JSON.parse(localStorage.getItem(key))
        if (obj === 'null' || obj === null) return null
        var expires = obj.expires,
            now = new Date().getTime(),
            time = obj.time

        if (now - time >= expires || now < time) {
            localStorage.removeItem(key)
            return null
        } else {
            return obj.value
        }
    },
    // removeLocalStorageItem
    removeLocalStorageItem(key) {
        if (this.getLocalStorageItem(key) !== null) {
            localStorage.removeItem(key)
            return this.getLocalStorageItem(key) === null ? true : false
        }
        return true
    },  
}
// 使用，假定，有一个缓存地址(address)，需要缓存一天，一天之后，自动失效
let address = JSON.parse(handleLocalStorage. getLocalStorageItem('address'))
let limitTime = address.time + address.expires
let now =  new Date().getTime()
// 已经过期， 重新定位
if (limitTime <= now) {
    handleLocalStorage.removeLocalStorageItem('address')
}
if(localStorage.address) {
    // 缓存未过期，直接取localStorage中的地址
} else {
   // 缓存过期，重新定位
   // 定位结束，需要将定位到的信息重新存入localStorage中
   handleLocalStorage.setLocalStorageItem('address', '新地址' , {expires: 1})
}

// 数组最大值
function arrayMax(arr) {
  return Math.max.apply(null, arr)
}
// 数组最小值
function arrayMin(arr) {
  return Math.min.apply(null, arr)
}
// 数组并集
function arrayUnion(arr1, arr2) {
  return [...new Set([...arr1, ...arr2])]
}
// 数组交集
function arrayIntersect(arr1, arr2) {
  // let arr3 = [...arr1].filter(value => arr2.includes(value))
  // return [...new Set([...arr3])]
  return [...new Set([...arr1].filter(value => arr2.includes(value)))]
}
// 数组差集
function arrayDiff(arr1, arr2) {
  return [...new Set([...arr1].filter(value => !arr2.includes(value)))]
}
// 数组去重
function arrayUnique(arr) {
  return [...new Set([...arr])]
}

// 微信环境
function isWeiXinWeb () {
  return navigator.userAgent.toLowerCase().indexOf('micromessenger') != -1
}
// 小程序环境
function isWechatApplet() {
    const ua = window.navigator.userAgent.toLowerCase()
    return new Promise(resolve => {
        if (ua.indexOf('micromessenger') == -1) {
            //不在微信或者小程序中
            resolve(false)
        } else {
            wx.miniProgram.getEnv(res => {
                if (res.miniprogram) {
                    //在小程序中
                    resolve(true)
                } else {
                    resolve(false)
                }
            })
        }
    })
}
// 使用说明
let isWx = isWeiXinWeb
let isWechatApp = false
isWechatApplet().then(res => {
  isWechatApp = res
}).catch(res => {
  isWechatApp = false
})

//身份证打马
function idCardMask (idCard = '') {
  return idCard.substr(0, 1) + idCard.slice(1, -4).replace(/\d/g, '*') + idCard.substr(-4)
}

//正则检测，手机号、姓名、邮箱、身份证
let RegExp = {
  // 检测手机号
  checkMobile(s) {
    var regu = /^[1][3,4,5,6,7,8,9][0-9]{9}$/
    if (regu.test(s)) {
      return true
    } else {
      return false
    }
  },
  // 检测姓名 必须要有两个汉字
  checkNomalName(s) {
    var regu = /^[\u4e00-\u9fa5]{2,}$/;
    if (regu.test(s)) {
      return true;
    } else {
      return false;
    }
  },
  // 检测邮箱
  isEmail(str) {
    var myReg = /^[-_A-Za-z0-9]+@([_A-Za-z0-9]+\.)+[A-Za-z0-9]{2,3}$/;
    if (myReg.test(str)) return true;
    return false;
  },
  //  检测身份证 
  checkIdCard(idCard) {
    var regIdCard = /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/
    //如果通过该验证，说明身份证格式正确，但准确性还需计算
    if (regIdCard.test(idCard)) {
      if (idCard.length == 18) {
        var idCardWi = new Array(7,  9,  10,  5,  8,  4,  2,  1,  6,  3,  7,  9,  10,  5,  8,  4,  2)  //将前17位加权因子保存在数组里
        var idCardY = new Array(1, 0, 10, 9, 8, 7, 6, 5, 4, 3, 2) //这是除以11后，可能产生的11位余数、验证码，也保存成数组
        var idCardWiSum = 0 //用来保存前17位各自乖以加权因子后的总和
        for (var i = 0; i < 17; i++) {
          idCardWiSum += idCard.substring(i, i + 1) * idCardWi[i]
        }
        var idCardMod = idCardWiSum % 11 //计算出校验码所在数组的位置
        var idCardLast = idCard.substring(17) //得到最后一位身份证号码
        //如果等于2，则说明校验码是10，身份证号码最后一位应该是X
        if (idCardMod == 2) {
          if (idCardLast == 'X' || idCardLast == 'x') {
            return true
          } else {
            return false
          }
        } else {
          //用计算出的验证码与最后一位身份证号码匹配，如果一致，说明通过，否则是无效的身份证号码
          if (idCardLast == idCardY[idCardMod]) {
            return true
          } else {
            return false
          }
        }
      }
    } else {
      return false
    }
  }
}

//获取设备号，安卓，ios，web
function getDeviceType() {
  var deviceType = 'WEB' //其他
  var u = navigator.userAgent
  var isAndroid = u.indexOf('Android') > -1 || u.indexOf('Adr') > -1 
  var isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/) 
  if (isAndroid) {
    deviceType = 'ANDROID'
  } else if (isiOS) {
    deviceType = 'IOS'
  }
  return deviceType
}

//设置、获取、删除、清除sessionStorage（localStorage也是同样操作）
function setSessionStorage(key, value) {
  sessionStorage.setItem(key, value)
}
function getSessionStorage(key) {
  return sessionStorage.getItem(key)
}
function delSessionStorage(key) {
  sessionStorage.removeItem(key) 
}
function clearSessionStorage() {
  sessionStorage.clear()
}

// 获取cookie第一种方法
function getCookie(e) {
    var i = document.cookie.match(new RegExp('(^| )' + e + '=([^;]*)(;|$)'))
    if (i !== null) {
      return i[2]
    } else {
      return ''
    }
}

// 获取cookie第二种方法
function getCookie(name = '') {
  if (document.cookie.length > 0) {
    let start = document.cookie.indexOf(name + '=')
    if (start !== -1) {
      start = start + name.length + 1
      let end = document.cookie.indexOf(';', start)
      if (end === -1) end = document.cookie.length
      return unescape(document.cookie.substring(start, end))
    }
  }
  return null
}

// 设置cookie
function setCookie(name, value, expireHours) {
  let exDate = new Date()
  exDate.setTime(exDate.getTime() + expireHours * 60 * 60 * 1000)
  document.cookie = name + '=' + escape(value) + (typeof expireHours === 'undefined' ? '' : ';expires=' + exDate.toGMTString())
}

// 删除cookie
function delCookie(name = '') {
  let exDate = new Date()
  exDate.setTime(exDate.getTime() - 1)
  let value = getCookie(name)
  if (value !== null) {
    document.cookie = name + '=' + escape(value) + ';expires=' + exDate.toGMTString()
  }
}

//url中取参数
function getQueryString(name) {
  if (undefined == window.location) return null
  var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)')
  var r = window.location.search.substr(1).match(reg)
  if (r != null) {
    return unescape(r[2].replace(/\%20/g, '+'))
  } else {
    return null
  }
}

// type   0：去除全部空格，1：去除左边空格，2：去除右边空格
function cTrim (sInputString, type) {
  var sTmpStr = ' ';
  var i = -1;

  if (type == 0 || type == 1) {
    while (sTmpStr == ' ') {
      ++i;
      sTmpStr = sInputString.substr(i, 1);
    }
    sInputString = sInputString.substring(i);
  }

  if (type == 0 || type == 2) {
    sTmpStr = ' ';
    i = sInputString.length;
    while (sTmpStr == ' ') {
      --i;
      sTmpStr = sInputString.substr(i, 1);
    }
    sInputString = sInputString.substring(0, i + 1);
  }
  return sInputString;
}

function formatDate(date, fmt) {
  if (/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (date.getFullYear() + '').substr(4 - RegExp.$1.length))
  }
  let o = {
    'M+': date.getMonth() + 1,
    'd+': date.getDate(),
    'h+': date.getHours(),
    'm+': date.getMinutes(),
    's+': date.getSeconds()
  }
  for (let k in o) {
    if (new RegExp(`(${k})`).test(fmt)) {
      let str = o[k] + ''
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? str : ('00' + str).substr(str.length))
    }
  }
  return fmt
}