package app.revanced.patches.macrofactor.misc.subscription

import app.revanced.patcher.fingerprint
import com.android.tools.smali.dexlib2.AccessFlags

internal val spoofAndroidCertFingerprint = fingerprint {
    accessFlags(AccessFlags.PUBLIC, AccessFlags.FINAL)
    custom { methodDef, classDef ->
        methodDef.name == "zza" && classDef.endsWith("Lcom/google/android/gms/internal/firebase-auth-api/zzaen;")
    }
}

internal val customerInfoFactoryBuildCustomerInfoFingerprint = fingerprint {
    strings("subscriber")
    custom { method, classDef ->
        classDef.endsWith("/CustomerInfoFactory;") && method.name == "buildCustomerInfo"
    }
}
