package app.aventurine.tibiabuddy

import app.aventurine.tibiabuddy.data.fileStorage.FileStorage
import app.aventurine.tibiabuddy.data.fileStorage.FileStorageImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    abstract fun bindFileStorage(
        fileStorageImpl: FileStorageImpl
    ): FileStorage
}