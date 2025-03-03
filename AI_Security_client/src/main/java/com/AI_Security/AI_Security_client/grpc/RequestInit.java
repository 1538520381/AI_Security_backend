// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: federal.proto

package com.AI_Security.AI_Security_client.grpc;

/**
 * Protobuf type {@code filetransfer.request_init}
 */
public  final class RequestInit extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:filetransfer.request_init)
        RequestInitOrBuilder {
private static final long serialVersionUID = 0L;
  // Use request_init.newBuilder() to construct.
  private RequestInit(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private RequestInit() {
    ctxContent_ = com.google.protobuf.ByteString.EMPTY;
    parasContent_ = com.google.protobuf.ByteString.EMPTY;
    round_ = 0;
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private RequestInit(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    this();
    if (extensionRegistry == null) {
      throw new NullPointerException();
    }
    int mutable_bitField0_ = 0;
    com.google.protobuf.UnknownFieldSet.Builder unknownFields =
        com.google.protobuf.UnknownFieldSet.newBuilder();
    try {
      boolean done = false;
      while (!done) {
        int tag = input.readTag();
        switch (tag) {
          case 0:
            done = true;
            break;
          default: {
            if (!parseUnknownFieldProto3(
                input, unknownFields, extensionRegistry, tag)) {
              done = true;
            }
            break;
          }
          case 10: {

            ctxContent_ = input.readBytes();
            break;
          }
          case 18: {

            parasContent_ = input.readBytes();
            break;
          }
          case 24: {

            round_ = input.readInt32();
            break;
          }
        }
      }
    } catch (com.google.protobuf.InvalidProtocolBufferException e) {
      throw e.setUnfinishedMessage(this);
    } catch (java.io.IOException e) {
      throw new com.google.protobuf.InvalidProtocolBufferException(
          e).setUnfinishedMessage(this);
    } finally {
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return Federal.internal_static_filetransfer_request_init_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return Federal.internal_static_filetransfer_request_init_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            RequestInit.class, RequestInit.Builder.class);
  }

  public static final int CTX_CONTENT_FIELD_NUMBER = 1;
  private com.google.protobuf.ByteString ctxContent_;
  /**
   * <pre>
   *密钥文件内容
   * </pre>
   *
   * <code>bytes ctx_content = 1;</code>
   */
  public com.google.protobuf.ByteString getCtxContent() {
    return ctxContent_;
  }

  public static final int PARAS_CONTENT_FIELD_NUMBER = 2;
  private com.google.protobuf.ByteString parasContent_;
  /**
   * <pre>
   *参数文件内容
   * </pre>
   *
   * <code>bytes paras_content = 2;</code>
   */
  public com.google.protobuf.ByteString getParasContent() {
    return parasContent_;
  }

  public static final int ROUND_FIELD_NUMBER = 3;
  private int round_;
  /**
   * <pre>
   *当前轮次从1开始
   * </pre>
   *
   * <code>int32 round = 3;</code>
   */
  public int getRound() {
    return round_;
  }

  private byte memoizedIsInitialized = -1;
  public final boolean isInitialized() {
    byte isInitialized = memoizedIsInitialized;
    if (isInitialized == 1) return true;
    if (isInitialized == 0) return false;

    memoizedIsInitialized = 1;
    return true;
  }

  public void writeTo(com.google.protobuf.CodedOutputStream output)
                      throws java.io.IOException {
    if (!ctxContent_.isEmpty()) {
      output.writeBytes(1, ctxContent_);
    }
    if (!parasContent_.isEmpty()) {
      output.writeBytes(2, parasContent_);
    }
    if (round_ != 0) {
      output.writeInt32(3, round_);
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (!ctxContent_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(1, ctxContent_);
    }
    if (!parasContent_.isEmpty()) {
      size += com.google.protobuf.CodedOutputStream
        .computeBytesSize(2, parasContent_);
    }
    if (round_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(3, round_);
    }
    size += unknownFields.getSerializedSize();
    memoizedSize = size;
    return size;
  }

  @Override
  public boolean equals(final Object obj) {
    if (obj == this) {
     return true;
    }
    if (!(obj instanceof RequestInit)) {
      return super.equals(obj);
    }
    RequestInit other = (RequestInit) obj;

    boolean result = true;
    result = result && getCtxContent()
        .equals(other.getCtxContent());
    result = result && getParasContent()
        .equals(other.getParasContent());
    result = result && (getRound()
        == other.getRound());
    result = result && unknownFields.equals(other.unknownFields);
    return result;
  }

  @Override
  public int hashCode() {
    if (memoizedHashCode != 0) {
      return memoizedHashCode;
    }
    int hash = 41;
    hash = (19 * hash) + getDescriptor().hashCode();
    hash = (37 * hash) + CTX_CONTENT_FIELD_NUMBER;
    hash = (53 * hash) + getCtxContent().hashCode();
    hash = (37 * hash) + PARAS_CONTENT_FIELD_NUMBER;
    hash = (53 * hash) + getParasContent().hashCode();
    hash = (37 * hash) + ROUND_FIELD_NUMBER;
    hash = (53 * hash) + getRound();
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static RequestInit parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static RequestInit parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static RequestInit parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static RequestInit parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static RequestInit parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static RequestInit parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static RequestInit parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static RequestInit parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static RequestInit parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static RequestInit parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static RequestInit parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static RequestInit parseFrom(
      com.google.protobuf.CodedInputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }

  public Builder newBuilderForType() { return newBuilder(); }
  public static Builder newBuilder() {
    return DEFAULT_INSTANCE.toBuilder();
  }
  public static Builder newBuilder(RequestInit prototype) {
    return DEFAULT_INSTANCE.toBuilder().mergeFrom(prototype);
  }
  public Builder toBuilder() {
    return this == DEFAULT_INSTANCE
        ? new Builder() : new Builder().mergeFrom(this);
  }

  @Override
  protected Builder newBuilderForType(
      BuilderParent parent) {
    Builder builder = new Builder(parent);
    return builder;
  }
  /**
   * Protobuf type {@code filetransfer.request_init}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:filetransfer.request_init)
          RequestInitOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Federal.internal_static_filetransfer_request_init_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Federal.internal_static_filetransfer_request_init_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              RequestInit.class, RequestInit.Builder.class);
    }

    // Construct using filetransfer.request_init.newBuilder()
    private Builder() {
      maybeForceBuilderInitialization();
    }

    private Builder(
        BuilderParent parent) {
      super(parent);
      maybeForceBuilderInitialization();
    }
    private void maybeForceBuilderInitialization() {
      if (com.google.protobuf.GeneratedMessageV3
              .alwaysUseFieldBuilders) {
      }
    }
    public Builder clear() {
      super.clear();
      ctxContent_ = com.google.protobuf.ByteString.EMPTY;

      parasContent_ = com.google.protobuf.ByteString.EMPTY;

      round_ = 0;

      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return Federal.internal_static_filetransfer_request_init_descriptor;
    }

    public RequestInit getDefaultInstanceForType() {
      return RequestInit.getDefaultInstance();
    }

    public RequestInit build() {
      RequestInit result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public RequestInit buildPartial() {
      RequestInit result = new RequestInit(this);
      result.ctxContent_ = ctxContent_;
      result.parasContent_ = parasContent_;
      result.round_ = round_;
      onBuilt();
      return result;
    }

    public Builder clone() {
      return (Builder) super.clone();
    }
    public Builder setField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.setField(field, value);
    }
    public Builder clearField(
        com.google.protobuf.Descriptors.FieldDescriptor field) {
      return (Builder) super.clearField(field);
    }
    public Builder clearOneof(
        com.google.protobuf.Descriptors.OneofDescriptor oneof) {
      return (Builder) super.clearOneof(oneof);
    }
    public Builder setRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        int index, Object value) {
      return (Builder) super.setRepeatedField(field, index, value);
    }
    public Builder addRepeatedField(
        com.google.protobuf.Descriptors.FieldDescriptor field,
        Object value) {
      return (Builder) super.addRepeatedField(field, value);
    }
    public Builder mergeFrom(com.google.protobuf.Message other) {
      if (other instanceof RequestInit) {
        return mergeFrom((RequestInit)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(RequestInit other) {
      if (other == RequestInit.getDefaultInstance()) return this;
      if (other.getCtxContent() != com.google.protobuf.ByteString.EMPTY) {
        setCtxContent(other.getCtxContent());
      }
      if (other.getParasContent() != com.google.protobuf.ByteString.EMPTY) {
        setParasContent(other.getParasContent());
      }
      if (other.getRound() != 0) {
        setRound(other.getRound());
      }
      this.mergeUnknownFields(other.unknownFields);
      onChanged();
      return this;
    }

    public final boolean isInitialized() {
      return true;
    }

    public Builder mergeFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws java.io.IOException {
      RequestInit parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (RequestInit) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }

    private com.google.protobuf.ByteString ctxContent_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <pre>
     *密钥文件内容
     * </pre>
     *
     * <code>bytes ctx_content = 1;</code>
     */
    public com.google.protobuf.ByteString getCtxContent() {
      return ctxContent_;
    }
    /**
     * <pre>
     *密钥文件内容
     * </pre>
     *
     * <code>bytes ctx_content = 1;</code>
     */
    public Builder setCtxContent(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      ctxContent_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *密钥文件内容
     * </pre>
     *
     * <code>bytes ctx_content = 1;</code>
     */
    public Builder clearCtxContent() {
      
      ctxContent_ = getDefaultInstance().getCtxContent();
      onChanged();
      return this;
    }

    private com.google.protobuf.ByteString parasContent_ = com.google.protobuf.ByteString.EMPTY;
    /**
     * <pre>
     *参数文件内容
     * </pre>
     *
     * <code>bytes paras_content = 2;</code>
     */
    public com.google.protobuf.ByteString getParasContent() {
      return parasContent_;
    }
    /**
     * <pre>
     *参数文件内容
     * </pre>
     *
     * <code>bytes paras_content = 2;</code>
     */
    public Builder setParasContent(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  
      parasContent_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *参数文件内容
     * </pre>
     *
     * <code>bytes paras_content = 2;</code>
     */
    public Builder clearParasContent() {
      
      parasContent_ = getDefaultInstance().getParasContent();
      onChanged();
      return this;
    }

    private int round_ ;
    /**
     * <pre>
     *当前轮次从1开始
     * </pre>
     *
     * <code>int32 round = 3;</code>
     */
    public int getRound() {
      return round_;
    }
    /**
     * <pre>
     *当前轮次从1开始
     * </pre>
     *
     * <code>int32 round = 3;</code>
     */
    public Builder setRound(int value) {
      
      round_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *当前轮次从1开始
     * </pre>
     *
     * <code>int32 round = 3;</code>
     */
    public Builder clearRound() {
      
      round_ = 0;
      onChanged();
      return this;
    }
    public final Builder setUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.setUnknownFieldsProto3(unknownFields);
    }

    public final Builder mergeUnknownFields(
        final com.google.protobuf.UnknownFieldSet unknownFields) {
      return super.mergeUnknownFields(unknownFields);
    }


    // @@protoc_insertion_point(builder_scope:filetransfer.request_init)
  }

  // @@protoc_insertion_point(class_scope:filetransfer.request_init)
  private static final RequestInit DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new RequestInit();
  }

  public static RequestInit getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<RequestInit>
      PARSER = new com.google.protobuf.AbstractParser<RequestInit>() {
    public RequestInit parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new RequestInit(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<RequestInit> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<RequestInit> getParserForType() {
    return PARSER;
  }

  public RequestInit getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

