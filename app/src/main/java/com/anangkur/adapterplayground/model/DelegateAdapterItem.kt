package com.anangkur.adapterplayground.model

interface DelegateAdapterItem {

    fun id(): Any

    fun content(): Any

    fun payload(other: Any): Payloadable = Payloadable.None

    /**
     * Simple marker interface for payloads
     */
    interface Payloadable {
        object None: Payloadable
    }
}