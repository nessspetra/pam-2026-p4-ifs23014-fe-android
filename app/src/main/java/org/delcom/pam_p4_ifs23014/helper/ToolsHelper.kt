package org.delcom.pam_p4_ifs23014.helper

import android.content.Context
import android.net.Uri
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.delcom.pam_p4_ifs23014.BuildConfig
import java.io.File

object ToolsHelper {

    /**
     * Mengambil URL gambar Tanaman dari Backend
     */
    fun getPlantImageUrl(plantId: String): String {
        return "${BuildConfig.BASE_URL_PANTS_API}plants/${plantId}/image"
    }

    /**
     * Mengambil URL gambar Makanan dari Backend (Fitur Baru)
     */
    fun getFoodImageUrl(foodId: String): String {
        return "${BuildConfig.BASE_URL_PANTS_API}foods/${foodId}/image"
    }

    /**
     * Mengambil URL foto Profil pengembang
     */
    fun getProfilePhotoUrl(): String {
        return "${BuildConfig.BASE_URL_PANTS_API}profile/photo"
    }

    /**
     * Mengubah String biasa menjadi RequestBody untuk keperluan Multipart (Text)
     */
    fun String.toRequestBodyText(): RequestBody {
        return this.toRequestBody("text/plain".toMediaTypeOrNull())
    }

    /**
     * Mengubah Uri gambar dari Galeri/Kamera menjadi MultipartBody.Part untuk diupload ke API
     */
    fun uriToMultipart(
        context: Context,
        uri: Uri,
        partName: String
    ): MultipartBody.Part {
        val file = uriToFile(context, uri)

        val requestFile = file
            .asRequestBody("image/*".toMediaTypeOrNull())

        return MultipartBody.Part.createFormData(
            partName,
            file.name,
            requestFile
        )
    }

    /**
     * Fungsi pembantu untuk mengubah Uri menjadi File fisik sementara di cache aplikasi
     */
    fun uriToFile(context: Context, uri: Uri): File {
        val file = File.createTempFile("upload", ".tmp", context.cacheDir)

        context.contentResolver.openInputStream(uri)?.use { input ->
            file.outputStream().use { output ->
                input.copyTo(output)
            }
        }

        return file
    }
}