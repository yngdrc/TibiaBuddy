package app.aventurine.tibiabuddy.map

import android.content.Context
import androidx.annotation.DrawableRes
import app.aventurine.tibiabuddy.R
import app.aventurine.tibiabuddy.map.models.MarkerEntity

object MarkerUtils {
    fun readMarkersData(appContext: Context): Collection<MarkerEntity> {
        val stream = appContext.applicationContext.assets.open("minimap/minimapmarkers.bin")
        val bytes = stream.readBytes().toMutableList()
        stream.close()

        return bytes.splitMarkers()
    }

    private fun MutableList<Byte>.splitMarkers(): Collection<MarkerEntity> {
        val preparedMarkers = mutableListOf<MarkerEntity>()

        do {
            val splitList = this.subList(
                fromIndex = 0,
                toIndex = this[1].toInt() + 2
            )

            this.drop(splitList.size)
            preparedMarkers.add(splitList.toMutableList().toMarkerEntity())
            splitList.clear()
        } while (this.isNotEmpty())

        return preparedMarkers
    }

    private fun List<Byte>.toMarkerEntity(): MarkerEntity {
        val coordinateDataBlockSize = this[3].toInt()
        val coordinateDataBlock = this.subList(fromIndex = 2, toIndex = coordinateDataBlockSize + 3)
        val floorId = this[coordinateDataBlock.size + 2].toInt()
        val iconId = this[coordinateDataBlock.size + 4].toInt()
        val markerDescriptionBlockSize = this[coordinateDataBlock.size + 6].toInt()
        val markerDescription = this.subList(
            fromIndex = coordinateDataBlock.size + 7,
            toIndex = coordinateDataBlock.size + 7 + markerDescriptionBlockSize
        ).let { String(it.toByteArray(), Charsets.UTF_8) }


        return MarkerEntity(
            x = getX(coordinateDataBlock = coordinateDataBlock),
            y = getY(coordinateDataBlock = coordinateDataBlock),
            floorId = floorId,
            iconRes = getMarkerDrawableRes(iconId = iconId),
            markerDescription = markerDescription
        )
    }

    @DrawableRes
    private fun getMarkerDrawableRes(
        iconId: Int
    ): Int = when (iconId) {
        0x00 -> R.drawable.marker_checkmark
        0x01 -> R.drawable.marker_questionmark
        0x02 -> R.drawable.marker_exclamationmark
        0x03 -> R.drawable.marker_star
        0x04 -> R.drawable.marker_crossmark
        0x05 -> R.drawable.marker_cross
        0x06 -> R.drawable.marker_lips
        0x07 -> R.drawable.marker_spear
        0x08 -> R.drawable.marker_sword
        0x09 -> R.drawable.marker_flag
        0x0A -> R.drawable.marker_lock
        0x0B -> R.drawable.marker_bag
        0x0C -> R.drawable.marker_skull
        0x0D -> R.drawable.marker_dollar
        0x0E -> R.drawable.marker_up
        0x0F -> R.drawable.marker_down
        0x10 -> R.drawable.marker_right
        0x11 -> R.drawable.marker_left
        0x12 -> R.drawable.marker_green_up
        0x13 -> R.drawable.marker_green_down
        else -> throw IllegalArgumentException()
    }

    private fun getX(
        coordinateDataBlock: List<Byte>
    ): Double = coordinateDataBlock[3].toDouble() + 128 *
            coordinateDataBlock[4].toDouble() + 16384 *
            coordinateDataBlock[5].toDouble() + 16512

    private fun getY(
        coordinateDataBlock: List<Byte>
    ): Double = coordinateDataBlock[7].toDouble() + 128 *
            coordinateDataBlock[8].toDouble() + 16384 *
            coordinateDataBlock[9].toDouble() + 16512
}