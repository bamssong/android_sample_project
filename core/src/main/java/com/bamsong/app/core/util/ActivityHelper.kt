package com.bamsong.app.core.util

import android.content.Intent

private const val PACKAGE_NAME = "com.bamsong.app"

fun intentTo(addressableActivity: AddressableActivity) : Intent {
    return Intent(Intent.ACTION_VIEW).setClassName(
        PACKAGE_NAME,
        addressableActivity.className
    )
}

interface AddressableActivity {
    val className: String
}

object Activities {
    object Main: AddressableActivity {
        override val className: String = "$PACKAGE_NAME.MainActivity"
    }

    object List: AddressableActivity {
        override val className: String = "$PACKAGE_NAME.ListActivity"
        const val EXTRA_TOKEN_ID ="token_id"
        const val EXTRA_TAB_ID =  "tabId"
    }

    object Detail {
        const val EXTRA_CONTENT_ID = "contentId"
        const val EXTRA_TOKEN_ID ="token_id"

        object Default: AddressableActivity {
            override val className: String = "$PACKAGE_NAME.detail.DetailActivity"
        }
        object Detail2: AddressableActivity {
            override val className: String = "$PACKAGE_NAME.detail2.ui.Detail2Activity"
        }
        object Detail3: AddressableActivity {
            override val className: String = "$PACKAGE_NAME.detail3.ui.Detail3Activity"
        }
    }

    object Search: AddressableActivity {
        override val className: String = "$PACKAGE_NAME.search.SearchActivity"
    }

}