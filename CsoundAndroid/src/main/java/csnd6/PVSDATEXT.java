/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 3.0.7
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package csnd6;

public class PVSDATEXT {
  private transient long swigCPtr;
  protected transient boolean swigCMemOwn;

  protected PVSDATEXT(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
  }

  protected static long getCPtr(PVSDATEXT obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  protected void finalize() {
    delete();
  }

  public synchronized void delete() {
    if (swigCPtr != 0) {
      if (swigCMemOwn) {
        swigCMemOwn = false;
        csndJNI.delete_PVSDATEXT(swigCPtr);
      }
      swigCPtr = 0;
    }
  }

  public void setN(SWIGTYPE_p_int32 value) {
    csndJNI.PVSDATEXT_N_set(swigCPtr, this, SWIGTYPE_p_int32.getCPtr(value));
  }

  public SWIGTYPE_p_int32 getN() {
    return new SWIGTYPE_p_int32(csndJNI.PVSDATEXT_N_get(swigCPtr, this), true);
  }

  public void setSliding(int value) {
    csndJNI.PVSDATEXT_sliding_set(swigCPtr, this, value);
  }

  public int getSliding() {
    return csndJNI.PVSDATEXT_sliding_get(swigCPtr, this);
  }

  public void setNB(SWIGTYPE_p_int32 value) {
    csndJNI.PVSDATEXT_NB_set(swigCPtr, this, SWIGTYPE_p_int32.getCPtr(value));
  }

  public SWIGTYPE_p_int32 getNB() {
    return new SWIGTYPE_p_int32(csndJNI.PVSDATEXT_NB_get(swigCPtr, this), true);
  }

  public void setOverlap(SWIGTYPE_p_int32 value) {
    csndJNI.PVSDATEXT_overlap_set(swigCPtr, this, SWIGTYPE_p_int32.getCPtr(value));
  }

  public SWIGTYPE_p_int32 getOverlap() {
    return new SWIGTYPE_p_int32(csndJNI.PVSDATEXT_overlap_get(swigCPtr, this), true);
  }

  public void setWinsize(SWIGTYPE_p_int32 value) {
    csndJNI.PVSDATEXT_winsize_set(swigCPtr, this, SWIGTYPE_p_int32.getCPtr(value));
  }

  public SWIGTYPE_p_int32 getWinsize() {
    return new SWIGTYPE_p_int32(csndJNI.PVSDATEXT_winsize_get(swigCPtr, this), true);
  }

  public void setWintype(int value) {
    csndJNI.PVSDATEXT_wintype_set(swigCPtr, this, value);
  }

  public int getWintype() {
    return csndJNI.PVSDATEXT_wintype_get(swigCPtr, this);
  }

  public void setFormat(SWIGTYPE_p_int32 value) {
    csndJNI.PVSDATEXT_format_set(swigCPtr, this, SWIGTYPE_p_int32.getCPtr(value));
  }

  public SWIGTYPE_p_int32 getFormat() {
    return new SWIGTYPE_p_int32(csndJNI.PVSDATEXT_format_get(swigCPtr, this), true);
  }

  public void setFramecount(SWIGTYPE_p_uint32 value) {
    csndJNI.PVSDATEXT_framecount_set(swigCPtr, this, SWIGTYPE_p_uint32.getCPtr(value));
  }

  public SWIGTYPE_p_uint32 getFramecount() {
    return new SWIGTYPE_p_uint32(csndJNI.PVSDATEXT_framecount_get(swigCPtr, this), true);
  }

  public void setFrame(SWIGTYPE_p_float value) {
    csndJNI.PVSDATEXT_frame_set(swigCPtr, this, SWIGTYPE_p_float.getCPtr(value));
  }

  public SWIGTYPE_p_float getFrame() {
    long cPtr = csndJNI.PVSDATEXT_frame_get(swigCPtr, this);
    return (cPtr == 0) ? null : new SWIGTYPE_p_float(cPtr, false);
  }

  public PVSDATEXT() {
    this(csndJNI.new_PVSDATEXT(), true);
  }

}