package org.hades.sharemanager;

import android.app.Activity;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;


/**
 * Created by Hades on 2016/12/7.
 */

public class UmengShareUtils {

    /**
    * 创建时间 2016/12/7
    * auther Hades
    * 描述
     * @param umShareListener 分享回调做一些后续提醒和处理
    **/
    public static void doShare(Activity activity, String title, String imageUrl,
                               String content, String targetUrl, UMShareListener umShareListener){
        UMImage image = new UMImage(activity, imageUrl);//网络图片
//        new ShareAction(activity)
////                .withTitle(title)
//                .withMedia(image)
//                .withText(content)
////                .withTargetUrl(targetUrl)
//                .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
//                .setCallback(umShareListener)
//                .open();

        UMWeb web = new UMWeb(targetUrl);
        web.setTitle(title);//标题
        web.setThumb(image);  //缩略图
        web.setDescription(content);//描述
        new ShareAction(activity)
                .withMedia(web)
                .setDisplayList(SHARE_MEDIA.SINA,SHARE_MEDIA.QQ,SHARE_MEDIA.WEIXIN)
                .setCallback(umShareListener)
                .open();

    }
}
