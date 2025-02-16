data class NoTriplo(var dado: String) {
    var id: Int = 0;
    var genitor: NoTriplo? = null
    val arrayPointers: Array<NoTriplo?> = arrayOfNulls(5);
}