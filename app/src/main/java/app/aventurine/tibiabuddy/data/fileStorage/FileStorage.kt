package app.aventurine.tibiabuddy.data.fileStorage

import java.io.File

interface FileStorage {
    fun saveFile(fileName: String, fileData: ByteArray): Result<File>
    fun getFileIfExists(fileName: String): Result<File>
}