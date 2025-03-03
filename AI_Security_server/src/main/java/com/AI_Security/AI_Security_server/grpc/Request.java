// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: federal.proto

package com.AI_Security.AI_Security_server.grpc;

/**
 * Protobuf type {@code example.Request}
 */
public  final class Request extends
    com.google.protobuf.GeneratedMessageV3 implements
    // @@protoc_insertion_point(message_implements:example.Request)
        RequestOrBuilder {
private static final long serialVersionUID = 0L;
  // Use Request.newBuilder() to construct.
  private Request(com.google.protobuf.GeneratedMessageV3.Builder<?> builder) {
    super(builder);
  }
  private Request() {
    number_ = 0;
    round_ = 0;
    encryptedFileContent_ = java.util.Collections.emptyList();
    gradients_ = java.util.Collections.emptyList();
  }

  @Override
  public final com.google.protobuf.UnknownFieldSet
  getUnknownFields() {
    return this.unknownFields;
  }
  private Request(
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
          case 8: {

            number_ = input.readInt32();
            break;
          }
          case 16: {

            round_ = input.readInt32();
            break;
          }
          case 26: {
            if (!((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
              encryptedFileContent_ = new java.util.ArrayList<com.google.protobuf.ByteString>();
              mutable_bitField0_ |= 0x00000004;
            }
            encryptedFileContent_.add(input.readBytes());
            break;
          }
          case 34: {
            if (!((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
              gradients_ = new java.util.ArrayList<com.google.protobuf.ByteString>();
              mutable_bitField0_ |= 0x00000008;
            }
            gradients_.add(input.readBytes());
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
      if (((mutable_bitField0_ & 0x00000004) == 0x00000004)) {
        encryptedFileContent_ = java.util.Collections.unmodifiableList(encryptedFileContent_);
      }
      if (((mutable_bitField0_ & 0x00000008) == 0x00000008)) {
        gradients_ = java.util.Collections.unmodifiableList(gradients_);
      }
      this.unknownFields = unknownFields.build();
      makeExtensionsImmutable();
    }
  }
  public static final com.google.protobuf.Descriptors.Descriptor
      getDescriptor() {
    return Federal.internal_static_example_Request_descriptor;
  }

  protected FieldAccessorTable
      internalGetFieldAccessorTable() {
    return Federal.internal_static_example_Request_fieldAccessorTable
        .ensureFieldAccessorsInitialized(
            Request.class, Request.Builder.class);
  }

  private int bitField0_;
  public static final int NUMBER_FIELD_NUMBER = 1;
  private int number_;
  /**
   * <pre>
   *客户端数量
   * </pre>
   *
   * <code>int32 number = 1;</code>
   */
  public int getNumber() {
    return number_;
  }

  public static final int ROUND_FIELD_NUMBER = 2;
  private int round_;
  /**
   * <pre>
   *当前轮次
   * </pre>
   *
   * <code>int32 round = 2;</code>
   */
  public int getRound() {
    return round_;
  }

  public static final int ENCRYPTED_FILE_CONTENT_FIELD_NUMBER = 3;
  private java.util.List<com.google.protobuf.ByteString> encryptedFileContent_;
  /**
   * <pre>
   *加密文件内容
   * </pre>
   *
   * <code>repeated bytes encrypted_file_content = 3;</code>
   */
  public java.util.List<com.google.protobuf.ByteString>
      getEncryptedFileContentList() {
    return encryptedFileContent_;
  }
  /**
   * <pre>
   *加密文件内容
   * </pre>
   *
   * <code>repeated bytes encrypted_file_content = 3;</code>
   */
  public int getEncryptedFileContentCount() {
    return encryptedFileContent_.size();
  }
  /**
   * <pre>
   *加密文件内容
   * </pre>
   *
   * <code>repeated bytes encrypted_file_content = 3;</code>
   */
  public com.google.protobuf.ByteString getEncryptedFileContent(int index) {
    return encryptedFileContent_.get(index);
  }

  public static final int GRADIENTS_FIELD_NUMBER = 4;
  private java.util.List<com.google.protobuf.ByteString> gradients_;
  /**
   * <pre>
   *模型梯度文件
   * </pre>
   *
   * <code>repeated bytes gradients = 4;</code>
   */
  public java.util.List<com.google.protobuf.ByteString>
      getGradientsList() {
    return gradients_;
  }
  /**
   * <pre>
   *模型梯度文件
   * </pre>
   *
   * <code>repeated bytes gradients = 4;</code>
   */
  public int getGradientsCount() {
    return gradients_.size();
  }
  /**
   * <pre>
   *模型梯度文件
   * </pre>
   *
   * <code>repeated bytes gradients = 4;</code>
   */
  public com.google.protobuf.ByteString getGradients(int index) {
    return gradients_.get(index);
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
    if (number_ != 0) {
      output.writeInt32(1, number_);
    }
    if (round_ != 0) {
      output.writeInt32(2, round_);
    }
    for (int i = 0; i < encryptedFileContent_.size(); i++) {
      output.writeBytes(3, encryptedFileContent_.get(i));
    }
    for (int i = 0; i < gradients_.size(); i++) {
      output.writeBytes(4, gradients_.get(i));
    }
    unknownFields.writeTo(output);
  }

  public int getSerializedSize() {
    int size = memoizedSize;
    if (size != -1) return size;

    size = 0;
    if (number_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(1, number_);
    }
    if (round_ != 0) {
      size += com.google.protobuf.CodedOutputStream
        .computeInt32Size(2, round_);
    }
    {
      int dataSize = 0;
      for (int i = 0; i < encryptedFileContent_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeBytesSizeNoTag(encryptedFileContent_.get(i));
      }
      size += dataSize;
      size += 1 * getEncryptedFileContentList().size();
    }
    {
      int dataSize = 0;
      for (int i = 0; i < gradients_.size(); i++) {
        dataSize += com.google.protobuf.CodedOutputStream
          .computeBytesSizeNoTag(gradients_.get(i));
      }
      size += dataSize;
      size += 1 * getGradientsList().size();
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
    if (!(obj instanceof Request)) {
      return super.equals(obj);
    }
    Request other = (Request) obj;

    boolean result = true;
    result = result && (getNumber()
        == other.getNumber());
    result = result && (getRound()
        == other.getRound());
    result = result && getEncryptedFileContentList()
        .equals(other.getEncryptedFileContentList());
    result = result && getGradientsList()
        .equals(other.getGradientsList());
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
    hash = (37 * hash) + NUMBER_FIELD_NUMBER;
    hash = (53 * hash) + getNumber();
    hash = (37 * hash) + ROUND_FIELD_NUMBER;
    hash = (53 * hash) + getRound();
    if (getEncryptedFileContentCount() > 0) {
      hash = (37 * hash) + ENCRYPTED_FILE_CONTENT_FIELD_NUMBER;
      hash = (53 * hash) + getEncryptedFileContentList().hashCode();
    }
    if (getGradientsCount() > 0) {
      hash = (37 * hash) + GRADIENTS_FIELD_NUMBER;
      hash = (53 * hash) + getGradientsList().hashCode();
    }
    hash = (29 * hash) + unknownFields.hashCode();
    memoizedHashCode = hash;
    return hash;
  }

  public static Request parseFrom(
      java.nio.ByteBuffer data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Request parseFrom(
      java.nio.ByteBuffer data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Request parseFrom(
      com.google.protobuf.ByteString data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Request parseFrom(
      com.google.protobuf.ByteString data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Request parseFrom(byte[] data)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data);
  }
  public static Request parseFrom(
      byte[] data,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws com.google.protobuf.InvalidProtocolBufferException {
    return PARSER.parseFrom(data, extensionRegistry);
  }
  public static Request parseFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Request parseFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input, extensionRegistry);
  }
  public static Request parseDelimitedFrom(java.io.InputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input);
  }
  public static Request parseDelimitedFrom(
      java.io.InputStream input,
      com.google.protobuf.ExtensionRegistryLite extensionRegistry)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseDelimitedWithIOException(PARSER, input, extensionRegistry);
  }
  public static Request parseFrom(
      com.google.protobuf.CodedInputStream input)
      throws java.io.IOException {
    return com.google.protobuf.GeneratedMessageV3
        .parseWithIOException(PARSER, input);
  }
  public static Request parseFrom(
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
  public static Builder newBuilder(Request prototype) {
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
   * Protobuf type {@code example.Request}
   */
  public static final class Builder extends
      com.google.protobuf.GeneratedMessageV3.Builder<Builder> implements
      // @@protoc_insertion_point(builder_implements:example.Request)
          RequestOrBuilder {
    public static final com.google.protobuf.Descriptors.Descriptor
        getDescriptor() {
      return Federal.internal_static_example_Request_descriptor;
    }

    protected FieldAccessorTable
        internalGetFieldAccessorTable() {
      return Federal.internal_static_example_Request_fieldAccessorTable
          .ensureFieldAccessorsInitialized(
              Request.class, Request.Builder.class);
    }

    // Construct using example.Request.newBuilder()
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
      number_ = 0;

      round_ = 0;

      encryptedFileContent_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000004);
      gradients_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000008);
      return this;
    }

    public com.google.protobuf.Descriptors.Descriptor
        getDescriptorForType() {
      return Federal.internal_static_example_Request_descriptor;
    }

    public Request getDefaultInstanceForType() {
      return Request.getDefaultInstance();
    }

    public Request build() {
      Request result = buildPartial();
      if (!result.isInitialized()) {
        throw newUninitializedMessageException(result);
      }
      return result;
    }

    public Request buildPartial() {
      Request result = new Request(this);
      int from_bitField0_ = bitField0_;
      int to_bitField0_ = 0;
      result.number_ = number_;
      result.round_ = round_;
      if (((bitField0_ & 0x00000004) == 0x00000004)) {
        encryptedFileContent_ = java.util.Collections.unmodifiableList(encryptedFileContent_);
        bitField0_ = (bitField0_ & ~0x00000004);
      }
      result.encryptedFileContent_ = encryptedFileContent_;
      if (((bitField0_ & 0x00000008) == 0x00000008)) {
        gradients_ = java.util.Collections.unmodifiableList(gradients_);
        bitField0_ = (bitField0_ & ~0x00000008);
      }
      result.gradients_ = gradients_;
      result.bitField0_ = to_bitField0_;
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
      if (other instanceof Request) {
        return mergeFrom((Request)other);
      } else {
        super.mergeFrom(other);
        return this;
      }
    }

    public Builder mergeFrom(Request other) {
      if (other == Request.getDefaultInstance()) return this;
      if (other.getNumber() != 0) {
        setNumber(other.getNumber());
      }
      if (other.getRound() != 0) {
        setRound(other.getRound());
      }
      if (!other.encryptedFileContent_.isEmpty()) {
        if (encryptedFileContent_.isEmpty()) {
          encryptedFileContent_ = other.encryptedFileContent_;
          bitField0_ = (bitField0_ & ~0x00000004);
        } else {
          ensureEncryptedFileContentIsMutable();
          encryptedFileContent_.addAll(other.encryptedFileContent_);
        }
        onChanged();
      }
      if (!other.gradients_.isEmpty()) {
        if (gradients_.isEmpty()) {
          gradients_ = other.gradients_;
          bitField0_ = (bitField0_ & ~0x00000008);
        } else {
          ensureGradientsIsMutable();
          gradients_.addAll(other.gradients_);
        }
        onChanged();
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
      Request parsedMessage = null;
      try {
        parsedMessage = PARSER.parsePartialFrom(input, extensionRegistry);
      } catch (com.google.protobuf.InvalidProtocolBufferException e) {
        parsedMessage = (Request) e.getUnfinishedMessage();
        throw e.unwrapIOException();
      } finally {
        if (parsedMessage != null) {
          mergeFrom(parsedMessage);
        }
      }
      return this;
    }
    private int bitField0_;

    private int number_ ;
    /**
     * <pre>
     *客户端数量
     * </pre>
     *
     * <code>int32 number = 1;</code>
     */
    public int getNumber() {
      return number_;
    }
    /**
     * <pre>
     *客户端数量
     * </pre>
     *
     * <code>int32 number = 1;</code>
     */
    public Builder setNumber(int value) {
      
      number_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *客户端数量
     * </pre>
     *
     * <code>int32 number = 1;</code>
     */
    public Builder clearNumber() {
      
      number_ = 0;
      onChanged();
      return this;
    }

    private int round_ ;
    /**
     * <pre>
     *当前轮次
     * </pre>
     *
     * <code>int32 round = 2;</code>
     */
    public int getRound() {
      return round_;
    }
    /**
     * <pre>
     *当前轮次
     * </pre>
     *
     * <code>int32 round = 2;</code>
     */
    public Builder setRound(int value) {
      
      round_ = value;
      onChanged();
      return this;
    }
    /**
     * <pre>
     *当前轮次
     * </pre>
     *
     * <code>int32 round = 2;</code>
     */
    public Builder clearRound() {
      
      round_ = 0;
      onChanged();
      return this;
    }

    private java.util.List<com.google.protobuf.ByteString> encryptedFileContent_ = java.util.Collections.emptyList();
    private void ensureEncryptedFileContentIsMutable() {
      if (!((bitField0_ & 0x00000004) == 0x00000004)) {
        encryptedFileContent_ = new java.util.ArrayList<com.google.protobuf.ByteString>(encryptedFileContent_);
        bitField0_ |= 0x00000004;
       }
    }
    /**
     * <pre>
     *加密文件内容
     * </pre>
     *
     * <code>repeated bytes encrypted_file_content = 3;</code>
     */
    public java.util.List<com.google.protobuf.ByteString>
        getEncryptedFileContentList() {
      return java.util.Collections.unmodifiableList(encryptedFileContent_);
    }
    /**
     * <pre>
     *加密文件内容
     * </pre>
     *
     * <code>repeated bytes encrypted_file_content = 3;</code>
     */
    public int getEncryptedFileContentCount() {
      return encryptedFileContent_.size();
    }
    /**
     * <pre>
     *加密文件内容
     * </pre>
     *
     * <code>repeated bytes encrypted_file_content = 3;</code>
     */
    public com.google.protobuf.ByteString getEncryptedFileContent(int index) {
      return encryptedFileContent_.get(index);
    }
    /**
     * <pre>
     *加密文件内容
     * </pre>
     *
     * <code>repeated bytes encrypted_file_content = 3;</code>
     */
    public Builder setEncryptedFileContent(
        int index, com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureEncryptedFileContentIsMutable();
      encryptedFileContent_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *加密文件内容
     * </pre>
     *
     * <code>repeated bytes encrypted_file_content = 3;</code>
     */
    public Builder addEncryptedFileContent(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureEncryptedFileContentIsMutable();
      encryptedFileContent_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *加密文件内容
     * </pre>
     *
     * <code>repeated bytes encrypted_file_content = 3;</code>
     */
    public Builder addAllEncryptedFileContent(
        Iterable<? extends com.google.protobuf.ByteString> values) {
      ensureEncryptedFileContentIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, encryptedFileContent_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *加密文件内容
     * </pre>
     *
     * <code>repeated bytes encrypted_file_content = 3;</code>
     */
    public Builder clearEncryptedFileContent() {
      encryptedFileContent_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000004);
      onChanged();
      return this;
    }

    private java.util.List<com.google.protobuf.ByteString> gradients_ = java.util.Collections.emptyList();
    private void ensureGradientsIsMutable() {
      if (!((bitField0_ & 0x00000008) == 0x00000008)) {
        gradients_ = new java.util.ArrayList<com.google.protobuf.ByteString>(gradients_);
        bitField0_ |= 0x00000008;
       }
    }
    /**
     * <pre>
     *模型梯度文件
     * </pre>
     *
     * <code>repeated bytes gradients = 4;</code>
     */
    public java.util.List<com.google.protobuf.ByteString>
        getGradientsList() {
      return java.util.Collections.unmodifiableList(gradients_);
    }
    /**
     * <pre>
     *模型梯度文件
     * </pre>
     *
     * <code>repeated bytes gradients = 4;</code>
     */
    public int getGradientsCount() {
      return gradients_.size();
    }
    /**
     * <pre>
     *模型梯度文件
     * </pre>
     *
     * <code>repeated bytes gradients = 4;</code>
     */
    public com.google.protobuf.ByteString getGradients(int index) {
      return gradients_.get(index);
    }
    /**
     * <pre>
     *模型梯度文件
     * </pre>
     *
     * <code>repeated bytes gradients = 4;</code>
     */
    public Builder setGradients(
        int index, com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureGradientsIsMutable();
      gradients_.set(index, value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *模型梯度文件
     * </pre>
     *
     * <code>repeated bytes gradients = 4;</code>
     */
    public Builder addGradients(com.google.protobuf.ByteString value) {
      if (value == null) {
    throw new NullPointerException();
  }
  ensureGradientsIsMutable();
      gradients_.add(value);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *模型梯度文件
     * </pre>
     *
     * <code>repeated bytes gradients = 4;</code>
     */
    public Builder addAllGradients(
        Iterable<? extends com.google.protobuf.ByteString> values) {
      ensureGradientsIsMutable();
      com.google.protobuf.AbstractMessageLite.Builder.addAll(
          values, gradients_);
      onChanged();
      return this;
    }
    /**
     * <pre>
     *模型梯度文件
     * </pre>
     *
     * <code>repeated bytes gradients = 4;</code>
     */
    public Builder clearGradients() {
      gradients_ = java.util.Collections.emptyList();
      bitField0_ = (bitField0_ & ~0x00000008);
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


    // @@protoc_insertion_point(builder_scope:example.Request)
  }

  // @@protoc_insertion_point(class_scope:example.Request)
  private static final Request DEFAULT_INSTANCE;
  static {
    DEFAULT_INSTANCE = new Request();
  }

  public static Request getDefaultInstance() {
    return DEFAULT_INSTANCE;
  }

  private static final com.google.protobuf.Parser<Request>
      PARSER = new com.google.protobuf.AbstractParser<Request>() {
    public Request parsePartialFrom(
        com.google.protobuf.CodedInputStream input,
        com.google.protobuf.ExtensionRegistryLite extensionRegistry)
        throws com.google.protobuf.InvalidProtocolBufferException {
      return new Request(input, extensionRegistry);
    }
  };

  public static com.google.protobuf.Parser<Request> parser() {
    return PARSER;
  }

  @Override
  public com.google.protobuf.Parser<Request> getParserForType() {
    return PARSER;
  }

  public Request getDefaultInstanceForType() {
    return DEFAULT_INSTANCE;
  }

}

