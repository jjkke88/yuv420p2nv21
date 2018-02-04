private byte[] yuv420_to_yuv420sp(byte[] yuv420p, int width, int height){
		int i, j;
		int y_size = width * height;
		int y_begin = 0;
		int u_begin = y_size;
		int v_begin = y_size * 5 / 4;
		int y_temp = 0;
		int uv_temp = y_size;
		byte[] yuv420sp = new byte[y_size + y_size / 2];

		// y
		for(i = 0;i < y_size;i++){
			yuv420sp[i] = yuv420p[i];
		}

		// u
		for(j = 0, i = 0; j < y_size / 2;j+=2, i++){
			// nv 21
			yuv420sp[uv_temp + j] = yuv420p[v_begin + i];
			yuv420sp[uv_temp + j + 1] = yuv420p[u_begin + i];
		}
		return yuv420sp;
