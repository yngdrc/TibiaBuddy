package app.aventurine.tibiabuddy.data.fileStorage

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.io.FileNotFoundException
import javax.inject.Inject

class FileStorageImpl @Inject constructor(
    @ApplicationContext private val context: Context
) : FileStorage {
    override fun saveFile(
        fileName: String,
        fileData: ByteArray
    ): Result<File> {
        val file = File(
            context.filesDir,
            fileName
        )

        return try {
            if (!file.exists())
                file.createNewFile()

            file.outputStream().use { outputStream ->
                outputStream.write(fileData)
            }

            Result.success(file)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override fun getFileIfExists(
        fileName: String
    ): Result<File> {
        val file = File(
            context.filesDir,
            fileName
        )

        return try {
            if (!file.exists())
                return Result.failure(FileNotFoundException())

            return Result.success(file)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}