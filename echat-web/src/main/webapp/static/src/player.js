const DPlayer = require('DPlayer');
const $ = require('jquery');

$("document").ready(function() {

    alert("begin");
    var option = {
        element: $('.dplayer')[0],                                         // Optional, player element
        autoplay: false,                                                   // Optional, autoplay video, not supported by mobile browsers
        theme: '#FADFA3',                                                  // Optional, theme color, default: #b7daff
        loop: true,                                                        // Optional, loop play music, default: true
        lang: 'zh',                                                        // Optional, language, `zh` for Chinese, `en` for English, default: Navigator language
        screenshot: true,                                                  // Optional, enable screenshot function, default: false, NOTICE: if set it to true, video and video poster must enable Cross-Origin
        hotkey: true,                                                      // Optional, binding hot key, including left right and Space, default: true
        preload: 'auto',                                                   // Optional, the way to load music, can be 'none' 'metadata' 'auto', default: 'auto'
        video: {                                                           // Required, video info
            url: 'http://devtest.qiniudn.com/若能绽放光芒.mp4',                                         // Required, video url
            pic: 'http://devtest.qiniudn.com/若能绽放光芒.png'                                          // Optional, music picture
        }
    };
    var dp = new DPlayer(option);
    dp.play();
});